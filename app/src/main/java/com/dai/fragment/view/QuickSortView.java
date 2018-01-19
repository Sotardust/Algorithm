package com.dai.fragment.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

import com.dai.fragment.BaseView;

/**
 * Created by dai on 2018/1/19.
 */

public class QuickSortView extends BaseView {

    public QuickSortView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int height = measureSize(defaultHeight, heightMeasureSpec);
        int width = measureSize(defaultWidth, widthMeasureSpec);
        setMeasuredDimension(width, height);
        startX = width / 2 - ints.length * distance / 2;
        startY = height * 4 / 5;
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int i = 0; i < ints.length; i++) {
            if (i == index) paint.setColor(Color.RED);
            else paint.setColor(Color.BLUE);
            canvas.drawLine(startX + i * distance, startY, startX + i * distance, startY - ints[i], paint);
        }
        getHandler().postDelayed(runnable, 2000);
    }

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            leftSort(ints, low, high);
            rightSort(ints, low, high);
            invalidate();
        }
    };

    /**
     * 基准位置的选取一般有三种方法
     * 固定切分，随机切分和三取样切分。
     * 固定切分的效率不太好，随机切分是常用的一种切分，效率比较高，最坏情况下时间复杂度有可能为O(N2).对于三数取中选择基准点是最理想的一种。
     * 本方法固定的切分方式
     *
     * @param start
     * @param end
     * @return
     */
    private int partition(int start, int end) {

        int low = start;
        int high = end;
        int key = ints[low];
        boolean isLeft = false;
        boolean isRight = false;
        while (low < high) {
            while (ints[high] >= key && high > low) {//从后半部分向前扫描
                high--;
            }
            ints[low] = ints[high];

            while (ints[low] <= key && high > low) { //从前半部分向后扫描
                low++;

            }
            ints[high] = ints[low];
        }
        ints[high] = key;
        return high;
    }

    int index = 0;
    int low, high;

    boolean isCycle = false;

    private void quickLeftSort() {
        if (low >= high) return;
        high = index - 1;
        System.out.println("high = " + high);
    }

    private void quickRightSort() {
        if (low >= high) return;
        low = index + 1;
        System.out.println("low = " + low);
    }

    /**
     * 设值
     *
     * @param distance 距离
     * @param ints     数组
     */
    public void setDistanceAndArray(float distance, int[] ints) {
        this.distance = distance;
        this.ints = ints;
        low = 0;
        high = ints.length - 1;
    }

    // 重新开始
    public void reset(int[] ints, int index) {
        this.index = index;
        this.ints = ints;
        invalidate();
    }

    private void sort(int[] ints, int low, int high) {
        if (low >= high) {
            return;
        }
        int index = partition(low, high);
        sort(ints, low, index - 1);
        sort(ints, index + 1, high);
    }

    private void leftSort(int[] ints, int low, int high) {
        if (low >= high) {
            return;
        }
        index = partition(low, high);
        leftSort(ints, low, index - 1);
    }

    private void rightSort(int[] ints, int low, int high) {

        if (low >= high) {
            return;
        }
        index = partition(low, high);
        rightSort(ints, index + 1, high);
    }

}
