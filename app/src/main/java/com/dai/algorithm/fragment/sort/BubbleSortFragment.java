package com.dai.algorithm.fragment.sort;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.dai.R;
import com.dai.algorithm.fragment.view.BubbleSortView;

import java.util.Random;

/**
 * Created by dai on 5017/5/26.
 * 冒泡排序原理：
 * 1、比较相邻的元素。如果第一个比第二个大，就交换他们两个。
 * 2、针对所有的元素重复以上的步骤，除了最后一个。
 */

public class BubbleSortFragment extends Fragment {

    int[] ints = new int[50];
    int[] reInts = new int[50];
    BubbleSortView bubbleSortView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bubble_sort, container, false);
        bubbleSortView = (BubbleSortView) view.findViewById(R.id.bubble_sort_view);
        final Random ran = new Random();
        for (int i = 0; i < ints.length; i++) {
            ints[i] = ran.nextInt(500) % (500 - 1 + 1) + 1;
        }
        bubbleSortView.setDistanceAndArray(8, ints);

        TextView start = (TextView) view.findViewById(R.id.bubble_start);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < reInts.length; i++) {
                    reInts[i] = ran.nextInt(500) % (500 - 1 + 1) + 1;
                }
                Toast.makeText(getContext(), "重新开始", Toast.LENGTH_SHORT).show();
                bubbleSortView.reset(reInts, 0);
            }
        });
        return view;
    }

    //冒泡排序算法
    private void bubbleSort() {
        for (int i = 0; i < ints.length; i++) {
            for (int j = i; j < ints.length - 1; j++) {
                if (ints[j] > ints[j + 1]) {
                    int temp = ints[j + 1];
                    ints[j + 1] = ints[j];
                    ints[j] = temp;
                }
            }
        }
    }

}
