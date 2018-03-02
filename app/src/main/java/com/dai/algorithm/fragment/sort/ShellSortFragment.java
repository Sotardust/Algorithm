package com.dai.algorithm.fragment.sort;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dai.R;
import com.dai.algorithm.fragment.BaseFragment;

import java.util.ArrayList;

/**
 * Created by dai on 2017/5/26.
 */

public class ShellSortFragment extends BaseFragment {

    private Integer integer;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shell_sort, container, false);
        final int[] ints = {50, 10, 30, 70, 40, 80, 60, 20};
        initView(view);
        sortTitle.setText("这是希尔排序");
        initText.setText(convert(ints));
        final ArrayList<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(2);
//        list.add(4);
//        list.add(5);
//        list.add(3);
        list.add(7);
        list.add(3);
        list.add(4);
        list.add(2);
        list.add(8);
        list.add(5);
        list.add(6);
        list.add(1);
//        7 3 4 2 8 5 6 1
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int value1 = 8;
                int value2 = 6;

                int number1 = solution(value1);
                System.out.println("number1 = " + number1);
                int number2 = solution(value2);
                System.out.println("number2 = " + number2);
                int value3 = greatestCommon(number1, (value1 - 2));
                int value4 = greatestCommon(number2, (value2 - 2));
                System.out.println("value4 = " + value4);
                System.out.println(number1 + "值为 = " + (number1 / value3 + "/" + ((value1 - 2) / value3)));
                System.out.println(number2 + "值为 = " + (number2 / value4 + "/" + ((value2 - 2) / value4)));
                endText.setText(convert(ints));
            }
        });


        return view;
    }

    private void shellSort(int[] ints) {
        int gap = ints.length / 2;
        while (1 <= gap) {
            for (int i = gap; i < ints.length; i++) {
                int j = 0;
                int temp = ints[i];
                for (j = i - gap; j >= 0 && temp < ints[j]; j = j - gap) {
                    ints[j + gap] = ints[j];
                }
                ints[j + gap] = temp;
            }
            gap = gap / 2;
        }
    }

    private int solution(int target) {
        int sum = 0;
        for (int i = 2; i < target; i++) {
            int value = target;
            while (value != 0) {
                sum = sum + value % i;
                value = value / i;
            }
        }
        return sum;
    }

    //更相减损术 求最大公约数
    private int greatestCommon(int num1, int num2) {
        while (num2 != (num1 - num2)) {
            int temp = num2;
            num2 = Math.abs(num1 - num2);
            num1 = temp;
        }
        return num2;
    }
}
