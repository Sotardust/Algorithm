package com.dai.fragment;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.dai.R;

import java.text.SimpleDateFormat;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by dai on 2017/5/26.
 * 冒泡排序原理：
 * 1、比较相邻的元素。如果第一个比第二个大，就交换他们两个。
 * 2、针对所有的元素重复以上的步骤，除了最后一个。
 */

public class BubbleSortFragment extends Fragment {

    int[] ints = {15, 25, 20, 30, 80, 45, 78, 50, 35, 60};

    Handler handler = null;
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:ss");

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bubble_sort, container, false);
        final TextView start = (TextView) view.findViewById(R.id.bubble_start);
        final RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.bubble_view);
        final BubbleSortView bubbleSortView = new BubbleSortView(getContext());
        bubbleSortView.start(ints);
        relativeLayout.addView(bubbleSortView);
        final Timer timer = new Timer();
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer.schedule(new TimerTask() {
                    int number = 0;

                    @Override
                    public void run() {
                        for (int i = 0; i < ints.length - 1; i++) {
                            if (ints[i] < ints[i + 1]) {
                                int temp = ints[i + 1];
                                ints[i + 1] = ints[i];
                                ints[i] = temp;
                            }
                            bubbleSortView.start(ints);
                        }
                        if (number == ints.length)
                            timer.cancel();
                        ++number;
                        System.out.println("number = " + number);
                    }
                }, 1, 800);
            }
        });
        return view;
    }


    public class BubbleSortView extends View {

        private Paint paint;
        private boolean isDynamic = false;

        public int getPosition() {
            return position;
        }

        public void setPosition(int position) {
            this.position = position;
        }

        private int position = 0;

        public void setInts(int[] ints) {
            this.ints = ints;
        }

        private int[] ints;

        public void setDynamic(boolean dynamic) {
            this.isDynamic = dynamic;
        }

        public BubbleSortView(Context context) {
            super(context);
            paint = new Paint(); //设置一个笔刷大小是3的黄色的画笔
            paint.setColor(Color.RED);
            paint.setStrokeJoin(Paint.Join.ROUND);
            paint.setStrokeCap(Paint.Cap.ROUND);
            paint.setStrokeWidth(5);
            paint.setAntiAlias(true);
            paint.setStyle(Paint.Style.STROKE);

        }

        @Override
        protected void onDraw(Canvas canvas) {
            canvas.translate(canvas.getWidth() * 3 / 5, 600); //将位置移动画纸的坐标点:150,150
            for (int i = 0; i < ints.length; i++) {
                canvas.drawLine(-i * 15, 0f, -i * 15, -ints[i] * 4, paint);
            }
        }


        public void start(int[] ints) {
            setInts(ints);
            System.out.println("ints = " + ints);
            postInvalidate();
        }


        /**
         * @param ints ints = {4, 15, 43, 56, 78, 24, 49};
         * @return 排序后的数组
         */
        private void bubbleSort(final int[] ints, final Canvas canvas, final Paint paint) {
            handler = new Handler() {
                @Override
                public void handleMessage(Message msg) {
                    if ((int) msg.obj == 0) {
                        System.out.println("msg.obj = " + msg.obj);
                        invalidate();
                    }
                }
            };
        }
    }
}
