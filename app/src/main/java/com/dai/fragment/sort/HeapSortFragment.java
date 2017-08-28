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

public class HeapSortFragment extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_heap_sort, container, false);
        final int[] ints = {3, 1, 8, 5, 2, 4, 9, 7, 6, 0};
        initView(view);
        sortTitle.setText("这是堆排序");
        initText.setText(convert(ints));
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                heapSort(ints);
                endText.setText(convert(ints));
            }
        });
        return view;
    }

    private void heapSort(int[] ints) {
        for (int i = 0; i < ints.length / 2; i++)
            heapAdjust(ints, i, ints.length - 1);
        for (int i = ints.length - 1; i > 0; --i) {
            //将堆顶结点与最后一个最后一个结点进行比较
            swap(ints, i, 0);
            //调整后可能违反堆的性质，需要对堆进行调整
            heapAdjust(ints, 0, i - 1);
        }
    }

    /**
     * 构建大根堆过程
     * 堆排序与快速排序，归并排序一样都是时间复杂度为O(N*logN)的几种常见排序方法
     *
     * @param ints   数组
     * @param root   根节点
     * @param length 数组长度
     */
    private void heapAdjust(int[] ints, int root, int length) {

        for (int i = root * 2 + 1; i < length; i++) {
            //若左子结点 root*2+1 小于右子节点 root*2+2 则值交换
            swap(ints, i, i + 1);
            // 父节点与左子节点比较 并进行直接换
            swap(ints, root, i);
        }
    }

    //数组大小比较并进行交换
    private void swap(int[] ints, int index1, int index2) {
        if (ints[index1] < ints[index2]) {
            int temp = ints[index1];
            ints[index1] = ints[index2];
            ints[index2] = temp;
        }
    }
}