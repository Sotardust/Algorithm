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

public class MergeSortFragment extends BaseFragment {

    private int number = 0;
    private int number1 = 0;
    private int number2 = 0;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_merge_sort, container, false);
        final int[] ints = {50, 10, 90, 30, 70, 40, 80, 60, 20};
        initView(view);
        sortTitle.setText("这是归并排序");
        initText.setText(convert(ints));
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mergeSort(ints, 0, ints.length - 1);
                endText.setText(convert(ints));
            }
        });
        return view;
    }

    private void merge(int[] ints, int left, int center, int right) {
        // 临时数组  
        int[] temp = new int[ints.length];
        // 右数组第一个元素索引  
        int mid = center + 1;
        // index 记录临时数组的索引  
        int index = left;
        // 缓存左数组第一个元素的索引  
        int tmp = left;
        while (left <= center && mid <= right) {
            // 从两个数组中取出最小的放入临时数组  
            if (ints[left] <= ints[mid]) {
                temp[index++] = ints[left++];
            } else {
                temp[index++] = ints[mid++];
            }
        }
        // 剩余部分依次放入临时数组（实际上两个while只会执行其中一个）  
        while (mid <= right) {
            temp[index++] = ints[mid++];
        }
        while (left <= center) {
            temp[index++] = ints[left++];
        }
        // 将临时数组中的内容拷贝回原数组中  
        // （原left-right范围的内容被复制回原数组）  
        while (tmp <= right) {
            ints[tmp] = temp[tmp++];
        }
    }


    private void mergeSort(int[] ints, int low, int high) {
        int mid = (low + high) / 2;
        if (low < high) {
            //左边归并排序
            mergeSort(ints, low, mid);
            //右边归并排序
            mergeSort(ints, mid + 1, high);
            //左右归并排序
            merge(ints, low, mid, high);
        }
    }
}