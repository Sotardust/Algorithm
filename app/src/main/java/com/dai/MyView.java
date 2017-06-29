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

    public void setPosition(int position) {
        this.position = position;
    }

    private int position;
    private int value;

    public void setMolecule(int molecule) {
        this.molecule = molecule;
    }

    private int molecule = 1;


    public void setDenominator(float denominator) {
        this.denominator = denominator;
    }

    private float denominator = 0;

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
        int width = canvas.getWidth() * (position + 1) / 10;
        canvas.translate(width + denominator * (canvas.getWidth() / 10), 500); //将位置移动画纸的坐标点:150,150
        canvas.drawLine(0f, 0f, -0f, -value, paint);
    }
}
