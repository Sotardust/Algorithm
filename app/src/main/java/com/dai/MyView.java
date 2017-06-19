package com.dai;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by dai on 2017/6/19.
 */

@SuppressLint("ViewConstructor")
public class MyView extends View {

    private Paint paint;
    private int position;
    private int value;

    public MyView(Context context, int position, int value) {
        super(context);
        this.position = position;
        this.value = value;
        paint = new Paint(); //设置一个笔刷大小是3的黄色的画笔
        paint.setColor(Color.BLUE);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeWidth(3);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        System.out.println("canvas.getWidth() = " + canvas.getWidth());
        canvas.translate(canvas.getWidth() * (position + 1) / 20, 500); //将位置移动画纸的坐标点:150,150
        System.out.println("canvas.getWidth() * (position + 1) / 10 = " + canvas.getWidth() * (position + 1) / 10);
        canvas.drawLine(0f, 0f, -0f, -value * 4, paint);
    }
}
