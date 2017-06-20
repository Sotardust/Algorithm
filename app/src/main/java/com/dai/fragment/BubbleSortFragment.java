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

/**
 * Created by dai on 2017/5/26.
 * 冒泡排序原理：
 * 1、比较相邻的元素。如果第一个比第二个大，就交换他们两个。
 * 2、针对所有的元素重复以上的步骤，除了最后一个。
 */

public class BubbleSortFragment extends Fragment {

//    int[] ints = {15, 25, 20, 30, 65, 45, 78, 50, 35, 60, 103, 86, 70, 43, 51, 32, 39, 76, 50};
        int[] ints = {15, 60, 103, 50};
    private static SparseArray<MyView> myViews = new SparseArray<>();

    Handler handler = null;
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:ss");

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bubble_sort, container, false);
        final TextView start = (TextView) view.findViewById(R.id.bubble_start);
        final FrameLayout linearLayout = (FrameLayout) view.findViewById(R.id.fragment);
//
        for (int i = 0; i < ints.length; i++) {
            MyView myView = new MyView(getContext(), i, ints[i]);
            System.out.println("i = " + i);
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
        LineEvaluator lineEvaluator = new LineEvaluator();
        for (int i = 0; i < ints.length - 1; i++) {
            System.out.println("*************************");
            for (int j = 0; j < ints.length - 1; j++) {
                if (ints[j] > ints[j + 1]) {
                    int temp = ints[j];
                    ints[j] = ints[j + 1];
                    ints[j + 1] = temp;
                    final ValueAnimator anim = ValueAnimator.ofObject(lineEvaluator, myViews.get(j), myViews.get(j + 1));
                    final int finalJ = j;
                    final int finalJ1 = j;
                    final int[] count = {0};
                    anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                        @Override
                        public void onAnimationUpdate(ValueAnimator animation) {
                            MyView myView = (MyView) animation.getAnimatedValue();
                            ++count[0];
                            myView.setMolecule(count[0]);
                            myView.setDenominator(animation.getAnimatedFraction());
                            System.out.println("count[0] = " + count[0]);
                            System.out.println("myView = " + myView);
                            myView.postInvalidate();
//                            System.out.println("j = " + finalJ);
                            System.out.println("animation = " + animation.getAnimatedFraction());
                        }
                    });

                    anim.setDuration(10000);
                    anim.start();
                }
            }
        }
    }

}
