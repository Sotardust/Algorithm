package com.dai.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dai.R;

/**
 * Created by dai on 2017/5/26.
 */

public class ShellSortFragment extends BaseFragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shell_sort, container, false);
        final int[] ints = {50, 10, 30, 70, 40, 80, 60, 20};
        initView(view);
        sortTitle.setText("这是希尔排序");
        initText.setText(convert(ints));
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shellSort(ints);
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

}
