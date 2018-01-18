package com.dai.fragment;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

/**
 * Created by dai on 2018/1/18.
 */

public class BubbleSortView extends View {
    public void setInts(int[] ints) {
        this.ints = ints;
        System.out.println("BubbleSortView.setInts");
    }

    private int[] ints = {};
    private int viewWidth;
    private int viewHeight;
    private Paint paint;
    private static final int defaultWidth = 600;//默认宽度
    private static final int defaultHeight = 1000;//默认高度

    private MyAnimation myAnimation;

    public BubbleSortView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();

    }

    private void init() {
        paint = new Paint();
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(5);
        myAnimation = new MyAnimation();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int height = measureSize(defaultHeight, heightMeasureSpec);
        int width = measureSize(defaultWidth, widthMeasureSpec);
        setMeasuredDimension(width, height);

        viewWidth = width;
        viewHeight = height;

    }

    private int measureSize(int defaultSize, int measureSpec) {
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

    boolean isFrist = true;
    boolean isMove = false;  // 移动

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        System.out.println("BubbleSortView.onDraw");

//            canvas.drawLine(viewWidth / 2 + i * 10 + distance, viewHeight / 2, viewWidth / 2 + i * 10 + distance, viewHeight / 2 - ints[i], paint);

//        for (int i = 0; i < ints.length; i++) {
//            canvas.drawLine(viewWidth / 2 + i * 10 + distance, viewHeight / 2, viewWidth / 2 + i * 10 + distance, viewHeight / 2 - ints[i], paint);
////            canvas.drawLine(viewWidth / 2 + i * 100 + distance, viewHeight / 2, viewWidth / 2 + i * 100 + distance, viewHeight / 2 - array[i], paint);
////            canvas.drawLine(viewWidth / 2 + i * 100 - distance, viewHeight / 2, viewWidth / 2 + i * 100 - distance, viewHeight / 2 - array[i + 1], paint);
//        }
        if (isFrist) {
            for (int i = 0; i < ints.length; i++) {
                if (i < 15) {
                    canvas.drawLine(viewWidth / 2 - i * 10 + distance, viewHeight / 2, viewWidth / 2 - i * 10 + distance, viewHeight / 2 - ints[i], paint);
                } else {
                    canvas.drawLine(viewWidth / 2 + (i - 15) * 10 + distance, viewHeight / 2, viewWidth / 2 + (i - 15) * 10 + distance, viewHeight / 2 - ints[i], paint);
                }
            }
            isFrist = false;
        }
        if (isMove) {
            canvas.drawLine(viewWidth / 2 + index * 10 + distance, viewHeight / 2, viewWidth / 2 + index * 10 + distance, viewHeight / 2 - ints[index], paint);
            canvas.drawLine(viewWidth / 2 + index * 10 - distance, viewHeight / 2, viewWidth / 2 + index * 10 - distance, viewHeight / 2 - ints[index + 1], paint);
        } else {
            isMove = true;
        }

        System.out.println("isMove = " + isMove);
        System.out.println("isFrist = " + isFrist);
        System.out.println("index = " + index);
    }

    int index = 0; //坐标
    float distance = 0;//距离
    int progressDistance = 1;

    private class MyAnimation extends Animation {
        @Override
        protected void applyTransformation(float interpolatedTime, Transformation t) {
            super.applyTransformation(interpolatedTime, t);
            distance = interpolatedTime * progressDistance;
            postInvalidate();
        }
    }

    public void setDuration(int progressDistance, int time, int index, int[] ints) {
        this.index = index;
        this.ints = ints;
        this.progressDistance = progressDistance;
        myAnimation.setDuration(time);
        startAnimation(myAnimation);
    }

    private void bubbleSort(Canvas canvas) {

        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints.length - 1; j++) {
                if (ints[j] > ints[j + 1]) {
                    int temp = ints[j + 1];
                    ints[j + 1] = ints[j];
                    ints[j] = temp;

                    canvas.translate(viewWidth / 2 + j * 5 + 5, viewHeight / 2 - ints[j + 1]);
                }
            }
        }
    }

    // 重绘线程
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
//            snowY += 10;
//            if (snowY > viewHeight) {//超出屏幕则重置雪球位置
//                snowY = 0;
//            }
            invalidate();
        }
    };

    private void canvasBubble(Canvas canvas) {
        for (int i = 0; i < ints.length; i++) {
            if (i < 15) {
                canvas.drawLine(viewWidth / 2 - 150 + i * 10, viewHeight / 2, viewWidth / 2 - 150 + i * 10, viewHeight / 2 - ints[i], paint);
            } else {
                canvas.drawLine(viewWidth / 2 + (i - 15) * 10, viewHeight / 2, viewWidth / 2 + (i - 15) * 10, viewHeight / 2 - ints[i], paint);
            }
        }
    }
}
