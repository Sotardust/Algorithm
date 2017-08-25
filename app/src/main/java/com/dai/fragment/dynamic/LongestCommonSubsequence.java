package com.dai.fragment.dynamic;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dai.R;
import com.dai.fragment.BaseFragment;

import java.util.ArrayList;

/**
 * Created by dai on 2017/7/31.
 * <p>
 * 利用动态规划求最大子段和问题
 */

public class LongestCommonSubsequence extends BaseFragment {

    //    int[] ints = {2, -4, 11, -3, 5, 16, -4, 1, 7};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_common_subsequence, container, false);

        initView(view);
        sortTitle.setText("这是求最大子段和问题");
//        initText.setText(String.valueOf(maxSum(ints)));
        initText.setText(String.valueOf(maxSubSum(ints, 0, ints.length - 1)));
//        commonSequence(ints, ints1);

        return view;
    }


    //动态规划求最大字段和问题
    int maxSum(int[] ints) {
        int sum = 0, b = 0;
        for (int anInt : ints) {
            if (b > 0) {
                b += anInt;
            } else {
                b = anInt;
            }

            if (b > sum) {
                sum = b;
            }
        }
        return sum;
    }

    //分治法求最大字段和问题
    int maxSubSum(int[] ints, int left, int right) {
        int sum = 0;
        if (left == right) sum = ints[left] > 0 ? ints[left] : 0;
        int center = (left + right) / 2;
        int leftSum = maxSubSum(ints, left, center);
        int rightSum = maxSubSum(ints, center + 1, right);

        int s1 = 0, lefts = 0;
        for (int i = center; i >= left; i--) {
            lefts += ints[i];
            if (lefts > s1) s1 = lefts;
        }
        int s2 = 0, rights = 0;
        for (int i = center + 1; i <= right; i++) {
            rights += ints[i];
            if (rights > s2) s2 = rights;
        }

        sum = s1 + s2;
        if (leftSum >= sum) sum = leftSum;
        if (rightSum >= sum) sum = rightSum;

        return sum;
    }


    int[] ints = {-2, 11, -4, 13, -5, -2};
    int[] ints1 = {5, 11, -4, 13, 6, -2};

    //最长公共子序列问题：LCS
    void commonSequence(int a[], int b[]) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();//保存所有公共子序列
        for (int i = 0; i < a.length; i++) {
            int index = i;
            ArrayList<Integer> temp = new ArrayList<>();  //保存公共子序列
            boolean flag = false;
            for (int aB : b) {
                if (index < a.length && a[index] == aB) {
                    ++index;
                    flag = true;
                    temp.add(aB);
                } else {
                    if (flag) break;
                }
            }
            list.add(temp);
        }

        int index = 0;  //最长公共子序列下标
        int maxLength = 0;
        for (ArrayList<Integer> temp : list) {
            if (temp.size() > maxLength) {
                maxLength = temp.size();
                index = list.indexOf(temp);
            }
        }
    }
}
