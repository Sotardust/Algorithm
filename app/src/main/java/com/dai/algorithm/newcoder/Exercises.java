package com.dai.algorithm.newcoder;

import java.util.ArrayList;

/**
 * Created by dai on 2017/7/19.
 */

public class Exercises {

    public void main(){

    }
    private int solution(int target, ArrayList<Integer> array) {
        int length = target;
        for (int i = 0; i < array.size(); i++) {
            boolean flag = false;
            System.out.println("array = " + array);
            int min = array.get(1);
            for (int j = 1; j < array.size(); j++) {
                if (array.get(0) < array.get(j)) {
                    if (j != 1) {
                        length++;
                    }
                    break;
                }
                if (min < array.get(j) || array.get(0) < array.get(j)) {
                    System.out.println("array.get(" + j + ") = " + array.get(j));
                    min = array.get(j);
                    System.out.println("min = " + min);
                    length++;
                }
//                if (flag) ;
            }
            array.add(array.get(0));
            array.remove(0);
        }

        return length;
    }
}
