package com.dai.fragment.sort;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dai.R;
import com.dai.fragment.BaseFragment;

/**
 * Created by dai on 2017/5/26.
 */

public class InsertSortFragment extends BaseFragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_insert_sort, container, false);

        final int[] ints = {23, 56, 45, 12, 78, 56, 48, 36, 94, 58, 79};
        initView(view);
        sortTitle.setText("这是插入排序");
        initText.setText(convert(ints));
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                endText.setText(convert(insertSort(ints)));
            }
        });
        return view;
    }

    /**
     * 插入排序是将一个数据插入到已经排好序的有序数据中，从而得到一个新的、个数加一的有序数据，算法适用于少量数据的排序，时间复杂度为O(n^2)。
     *
     * @param ints {23, 56, 45, 12, 78, 56, 48, 36, 94, 58, 79}
     * @return 数组
     */
    private int[] insertSort(int[] ints) {

        for (int i = 1; i < ints.length; i++) {
            int temp = ints[i];
            int j = i - 1;
            while (j > -1 && temp < ints[j]) {
                ints[j + 1] = ints[j];
                j--;
            }
            ints[j + 1] = temp;
        }
        return ints;
    }
}