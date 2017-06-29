package com.dai.util;

import android.animation.TypeEvaluator;
import android.util.SparseArray;

import com.dai.MyView;

/**
 * Created by dai on 2017/6/19.
 */

public class LineEvaluator implements TypeEvaluator {
    private SparseArray<MyView> myViews;

//    public LineEvaluator(SparseArray<MyView> myViews) {
//        this.myViews = myViews;
//    }
//
    @Override
    public Object evaluate(float fraction, Object startValue, Object endValue) {

//        System.out.println("fraction = " + fraction);
//        System.out.println("startValue = " + startValue);
//        System.out.println("endValue = " + endValue);


//        int start = myViews.indexOfValue((MyView) startValue);
//        int end = myViews.indexOfValue((MyView) endValue);
//        System.out.println("start = " + start);
//        System.out.println("end = " + end);
//        MyView myView = myViews.get(start);
//        myViews.put(start, myViews.get(end));
//        myViews.put(end, myView);
        return (MyView) startValue;


        }
//    @Override
//    public Object evaluate(float fraction, Object startValue, Object endValue) {
//        Point startPoint = (Point) startValue;
//        Point endPoint = (Point) endValue;
//        float x = startPoint.getX() + fraction * (endPoint.getX() - startPoint.getX());
//        float y = startPoint.getY() + fraction * (endPoint.getY() - startPoint.getY());
//        return new Point(x, y);
//    }


}
