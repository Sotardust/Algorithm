package com.dai.otheralgo;

import java.util.ArrayList;

/**
 * Created by dai on 2018/3/1.
 */
public class MyDynamic {


    private int[] ints = {-2, 11, -4, 13, -5, -2};
    private int[] ints1 = {5, 11, -4, 13, 6, -2};

    public MyDynamic() {
    }

    //动态规划求最大字段和问题
    public int maxSum() {
        int sum = 0;
        int temp = 0;
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] > 0) {
                temp = temp + ints[i];
            } else {
                temp = ints[i];
            }
            if (sum < temp) {
                sum = temp;
            }
        }
        return sum;
    }

    // 分治法求最大字段和问题
    public int maxSum(int[] ints, int left, int right) {
        int sum = 0;
        if (left == right) sum = ints[left] > 0 ? ints[left] : 0;
        int mid = (left + right) / 2;
        int leftSum = maxSum(ints, left, mid);
        int rightSum = maxSum(ints, mid, right);

        int s1 = 0, lefts = 0;
        for (int i = mid; i >= left; i--) {
            lefts += ints[i];
            if (lefts > s1) s1 = lefts;
        }
        int s2 = 0, rights = 0;
        for (int i = mid + 1; i <= right; i++) {
            rights += ints[i];
            if (rights > s2) s2 = rights;
        }

        sum = s1 + s2;

        if (leftSum > sum) sum = leftSum;
        if (rightSum > sum) sum = rightSum;
        return sum;
    }

    //最长公共子序列问题：LCS
    private void commonSequence(int[] a, int[] b) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();//保存所有公共子序列
        for (int i = 0; i < a.length; i++) {
            int index = i;
            boolean flag = false;
            ArrayList<Integer> temp = new ArrayList<>();
            for (int j = index; j < b.length; j++) {
                if (index < a.length && a[index] == b[j]) {
                    temp.add(b[j]);
                    flag = true;
                    ++index;
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


        ArrayList<Integer> temp = list.get(index);
        for (int i = 0; i < temp.size(); i++) {
            System.out.println("list = " + temp.get(i));
        }
    }

    //执行最长公共子序列问题：LCS
    public void executeCommonSequence() {
        commonSequence(ints, ints1);
    }

}
