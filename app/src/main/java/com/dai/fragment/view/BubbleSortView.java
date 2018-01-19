package com.dai.fragment.view;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

import com.dai.fragment.BaseView;

/**
 * Created by dai on 2018/1/18.
 */

public class BubbleSortView extends BaseView {
    private int index = 0; //当前移动的线条
    public BubbleSortView(Context context, @Nullable AttributeSet attrs) {
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
//            if (i == index) paint.setColor(Color.RED);
//            else paint.setColor(Color.BLUE);
            canvas.drawLine(startX + i * distance, startY, startX + i * distance, startY - ints[i], paint);
        }
        bubbleSort();
        invalidate();
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
    }

    // 重新开始
    public void reset(int[] ints, int index) {
        this.index = index;
        this.ints = ints;
        invalidate();
    }

    //冒泡排序  对数组进行排序 交换
    private void bubbleSort() {
        for (int i = 0; i < ints.length ; i++) {
            boolean flag = false;
            for (int j = i; j < ints.length - 1; j++) {
                if (ints[j] > ints[j + 1]) {
                    int temp = ints[j + 1];
                    ints[j + 1] = ints[j];
                    ints[j] = temp;
                    flag = true;
                    index = j;
//                    break; //注释掉看慢速观看整个冒泡过程
                }
            }
            if (flag) break;
        }
    }
}
