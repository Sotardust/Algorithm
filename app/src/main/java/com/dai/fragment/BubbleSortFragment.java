package com.dai.fragment;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.dai.MyView;
import com.dai.R;
import com.dai.util.LineEvaluator;

import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by dai on 5017/5/26.
 * 冒泡排序原理：
 * 1、比较相邻的元素。如果第一个比第二个大，就交换他们两个。
 * 2、针对所有的元素重复以上的步骤，除了最后一个。
 */

public class BubbleSortFragment extends Fragment {

    int[] ints = new int[10];
    private static SparseArray<MyView> myViews = new SparseArray<>();

    int index = -1;
    int index1 = -1;
    Handler handler = null;
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:ss");
    LineEvaluator lineEvaluator = new LineEvaluator();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bubble_sort, container, false);
        final TextView start = (TextView) view.findViewById(R.id.bubble_start);
        final FrameLayout linearLayout = (FrameLayout) view.findViewById(R.id.fragment);
        Random ran1 = new Random();
        for (int i = 0; i < 10; i++) {
            ints[i] = ran1.nextInt(500) % (500 - 1 + 1) + 1;
        }
        for (int i = 0; i < ints.length; i++) {
            MyView myView = new MyView(getContext(), i, ints[i]);
            myViews.put(i, myView);
            linearLayout.addView(myView);
        }
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bubbleSort();
            }
        });

        return view;
    }

    public void bubbleSort() {
        final Timer timer1 = new Timer();
        timer1.schedule(new TimerTask() {
            @Override
            public void run() {
                ++index1;
                if (index1 + 1 == ints.length - 1) {
                    timer1.cancel();
                }
                index = -1;
                traverseOnce();
            }
        }, 1, (ints.length * 10));
    }

    private void traverseOnce() {
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                ++index;
                if (index < ints.length - 1) {
                    if (ints[index] > ints[index + 1]) {
                        int temp = ints[index];
                        ints[index] = ints[index + 1];
                        ints[index + 1] = temp;
                        MyView viewTemp = myViews.get(index);
                        myViews.put(index, myViews.get(index + 1));
                        myViews.put(index + 1, viewTemp);
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                setAnimator(myViews.get(index), false, index + 1);
                                setAnimator(myViews.get(index + 1), true, index);
                            }
                        });
                    }
                } else {
                    timer.cancel();
                }
            }
        }, 1, 10);
    }

    private void setAnimator(MyView myview, final boolean flag, final int position) {
        final ValueAnimator anim = ValueAnimator.ofObject(lineEvaluator, myview, null);
        final int[] count = {0};
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                MyView myView = (MyView) animation.getAnimatedValue();
                ++count[0];
                myView.setMolecule(count[0]);
                myView.setPosition(position);
                int number = flag ? 1 : -1;
                myView.setDenominator(animation.getAnimatedFraction() * number);
                myView.postInvalidate();
            }
        });
        anim.setDuration(10);
        anim.start();
    }

}
