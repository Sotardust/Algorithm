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

public class HeapSortFragment extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_heap_sort, container, false);
        final int[] ints = {23, 56, 45, 12, 78, 58,40};
        initView(view);
        sortTitle.setText("这是堆排序");
        initText.setText(convert(ints));
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                endText.setText(convert(ints));
                heapSort(ints);
            }
        });
        return view;
    }

    /**
     * 堆排序与快速排序，归并排序一样都是时间复杂度为O(N*logN)的几种常见排序方法
     *
     * @param ints
     * @param root
     */
    private void heapAdjust(int[] ints, int root, int end) {
        int temp = ints[root];
        for (int i = root * 2 + 1; i < end; i++) {
            if (ints[i] < ints[i + 1]) ++i;
            if (temp > ints[i]) break;
            ints[root] = ints[i];
            root = i;
        }
        ints[root] = temp;
    }

    private void heapSort(int[] ints) {
        for (int i = 0; i < ints.length / 2; i++) heapAdjust(ints, i, ints.length - 1);
        System.out.println("convert(ints) = " + convert(ints));
        for (int i = ints.length - 1; i > 0; --i) {
            int temp = ints[i];
            ints[i] = ints[0];
            ints[0] = temp;
            heapAdjust(ints, 0, i-1);
            System.out.println("                                    ");
            System.out.println("convert(ints) = " + convert(ints));
        }


    }
}