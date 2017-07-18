package com.dai.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dai.R

/**
 * Created by dai on 2017/5/26.
 */

class QuickSortFragment : BaseFragment() {

    internal var ints = intArrayOf(48, 15, 24, 59, 64, 79, 97, 40)

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_quick_sort, container, false)
        initView(view)
        sortTitle.text = "这是快速排序"
        initText.text = convert(ints)
        start.setOnClickListener {
            sort(ints, 0, ints.size - 1)
            endText.text = convert(ints)
        }
        return view
    }

    /**
     * 基准位置的选取一般有三种方法
     * 固定切分，随机切分和三取样切分。
     * 固定切分的效率不太好，随机切分是常用的一种切分，效率比较高，最坏情况下时间复杂度有可能为O(N2).对于三数取中选择基准点是最理想的一种。
     * 本方法固定的切分方式
     * @param ints
     * @param start
     * @param end
     * @return
     */
    fun partition(ints: IntArray, start: Int, end: Int): Int {
        var low = start
        var high = end
        val key = ints[low]
        while (low < high) {
            while (ints[high] >= key && high > low) {//从后半部分向前扫描
                high--
            }
            ints[low] = ints[high]
            while (ints[low] <= key && high > low) { //从前半部分向后扫描
                low++
            }
            ints[high] = ints[low]
        }
        ints[high] = key
        return high
    }

    fun sort(ints: IntArray, low: Int, high: Int) {
        if (low >= high) {
            return
        }
        val index = partition(ints, low, high)
        sort(ints, low, index - 1)
        sort(ints, index + 1, high)
    }

}