package com.dai.algorithm.fragment.sort

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dai.R
import com.dai.algorithm.fragment.BaseFragment

/**
 * Created by dai on 2017/5/26.
 */

class SelectSortFragment : BaseFragment() {
    var ints = intArrayOf(48, 15, 64, 24, 59, 79, 97, 40)
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(R.layout.fragment_select_sort, container, false)
        initView(view)
        sortTitle.text = "这是选择排序"
        initText.text = convert(ints)
        start.setOnClickListener {
            selectSort(ints)
            endText.text = convert(ints)
        }
        return view
    }

    fun selectSort(ints: IntArray) {
        for (i in ints.indices) {
            var index = i
            (i..ints.size - 1)
                    .asSequence()
                    .filter { ints[index] > ints[it] }
                    .forEach { index = it }
            println("index = ${index}")
            println("ints[index] = ${ints[index]}")
            val temp = ints[i]
            ints[i] = ints[index]
            ints[index] = temp
        }
    }

//    private void selectSort(int[] ints) {
//        for (int i = 0; i < ints.length; i++) {
//            int index = i;
//            for (int j = i; j < ints.length; j++) {
//                if (ints[index] > ints[j]) {
//                    index = j;
//                }
//            }
//            int temp = ints[i];
//            ints[i] = ints[index];
//            ints[index] = temp;
//        }
//    }

}