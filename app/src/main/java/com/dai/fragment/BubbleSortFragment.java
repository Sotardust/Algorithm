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

/**
 * Created by dai on 2017/5/26.
 * 冒泡排序原理：
 * 1、比较相邻的元素。如果第一个比第二个大，就交换他们两个。
 * 2、针对所有的元素重复以上的步骤，除了最后一个。
 */

public class BubbleSortFragment extends Fragment {

    int[] ints = {4, 15, 43, 56, 78, 24, 49, 23, 89, 15, 25, 45, 4, 15, 43, 56, 78};

    Handler handler = null;
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:ss");

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bubble_sort, container, false);
        TextView start = (TextView) view.findViewById(R.id.bubble_start);
        final RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.bubble_view);
        final BubbleSortView bubbleSortView = new BubbleSortView(getContext());
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                relativeLayout.addView(bubbleSortView);

//                bubbleSortView.setDynamic(true) ;
//                bubbleSortView.invalidate();
//                relativeLayout.removeAllViews();
//                relativeLayout.addView(bubbleView);
            }
        });
        return view;
    }


    public class BubbleSortView extends View {

        private Paint paint;
        private boolean isDynamic = false;

        public void setDynamic(boolean dynamic) {
            this.isDynamic = dynamic;
        }

        public BubbleSortView(Context context) {
            super(context);
            paint = new Paint(); //设置一个笔刷大小是3的黄色的画笔
            paint.setColor(Color.BLUE);
            paint.setStrokeJoin(Paint.Join.ROUND);
            paint.setStrokeCap(Paint.Cap.ROUND);
            paint.setStrokeWidth(4);
            paint.setAntiAlias(true);
            paint.setStyle(Paint.Style.STROKE);

        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
//            if (isDynamic) {
//                System.out.println("BubbleSortView.onDraw");

            bubbleSort(ints, canvas, paint);
//            } else {
//                draw(canvas, paint);
//            }
        }

        public void draw(Canvas canvas, Paint paint) {
            canvas.translate(canvas.getWidth() * 3 / 5, 600); //将位置移动画纸的坐标点:150,150
            for (int i = 0; i < ints.length; i++) {
                canvas.drawLine(-i * 10, 0f, -i * 10, -ints[i] * 4, paint);
            }
        }


        /**
         * @param ints ints = {4, 15, 43, 56, 78, 24, 49};
         * @return 排序后的数组
         */
        private void bubbleSort(final int[] ints, final Canvas canvas, final Paint paint) {
            handler = new Handler() {
                @Override
                public void handleMessage(Message msg) {
                    if ((int)msg.obj == 0) {
                        System.out.println("msg.obj = " + msg.obj);
                        invalidate();
                    }
                }
            };
            canvas.translate(canvas.getWidth() * 3 / 5, 600);


            final Timer timer = new Timer();

//            final Thread thread = new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    for (int i = ints.length - 1; i > 0; i--) {
                        for (int j = 0; j < ints.length - 1; j++) {
                            if (ints[j] > ints[j + 1]) {
                                int temp = ints[j + 1];
                                ints[j + 1] = ints[j];
                                ints[j] = temp;
                            }
                            System.out.println("ints = " + ints[j]);


//                            Message message = new Message();
//                            try {
//                                Thread.sleep(100);
//                                canvas.drawLine(-finalI * 10, 0, -finalI * 10, -ints[finalJ] * 4, paint);
                                canvas.drawLine(-j * 10f, 0, -j * 10f, -ints[j] * 4f, paint);

////                                handler.sendEmptyMessage(0);
//                            } catch (InterruptedException e) {
//                                e.printStackTrace();
//                            }
                        }
//                    }
//                }
//            });
//            thread.start();
//            timer.cancel();
        }
    }
}
