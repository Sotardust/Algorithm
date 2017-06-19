package com.dai.util;

import android.animation.TypeEvaluator;
import android.util.SparseArray;

import com.dai.MyView;

/**
 * Created by dai on 2017/6/19.
 */

public class LineEvaluator implements TypeEvaluator {
    private SparseArray<MyView> myViews;

    public LineEvaluator(SparseArray<MyView> myViews) {
        this.myViews = myViews;
    }

    @Override
    public Object evaluate(float fraction, Object startValue, Object endValue) {


        int start = myViews.indexOfValue((MyView) startValue);
        int end = myViews.indexOfValue((MyView) endValue);
        MyView myView = myViews.get(start);
        myViews.put(start, myViews.get(end));
        myViews.put(end, myView);
        return myViews;
    }
}
