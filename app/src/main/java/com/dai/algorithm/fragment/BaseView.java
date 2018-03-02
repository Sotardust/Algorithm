package com.dai.algorithm.fragment;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by dai on 2018/1/19.
 */

public class BaseView extends View {

    protected static final int defaultWidth = 600;//默认宽度
    protected static final int defaultHeight = 1000;//默认高度
    protected int[] ints = null;
    protected Paint paint;
    protected float startX = 0.0f; //开始x轴位置
    protected float startY = 0.0f; //开始Y轴位置

    protected float distance = 0;//每个线条间隔的距离

    public BaseView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    protected void init() {
        paint = new Paint();
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(2);
    }

    protected int measureSize(int defaultSize, int measureSpec) {
        int result = defaultSize;
        int specMode = View.MeasureSpec.getMode(measureSpec);
        int specSize = View.MeasureSpec.getSize(measureSpec);

        if (specMode == View.MeasureSpec.EXACTLY) {
            result = specSize;
        } else if (specMode == View.MeasureSpec.AT_MOST) {
            result = Math.min(result, specSize);
        }
        return result;
    }

    protected String convert(int[] ints) {
        StringBuilder sb = new StringBuilder();
        for (int value : ints) {
            sb.append(value).append(",");
        }
        return sb.toString();
    }
}
