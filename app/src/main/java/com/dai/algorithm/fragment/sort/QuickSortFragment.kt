package com.dai.algorithm.fragment.sort

import com.dai.R
import com.dai.algorithm.fragment.BaseFragment
import com.dai.algorithm.fragment.view.QuickSortView
import java.util.*

/**
 * Created by dai on 2017/5/26.
 */

class QuickSortFragment : BaseFragment() {


    internal var ints = IntArray(150)
    internal var reInts = IntArray(150)
    override fun onCreateView(inflater: android.view.LayoutInflater?, container: android.view.ViewGroup?, savedInstanceState: android.os.Bundle?): android.view.View? {
        val view = inflater!!.inflate(com.dai.R.layout.fragment_quick_sort, container, false)
        val ran = Random()
        for (i in ints.indices) {
            ints[i] = ran.nextInt(500) % (500 - 1 + 1) + 1
        }
        val quickSortView = view.findViewById(R.id.quick_sort_view) as QuickSortView
        quickSortView.setDistanceAndArray(5f,ints)
        initView(view)
        sortTitle.text = "这是快速排序"


//        initText.text = convert(ints)
//        start.setOnClickListener {
//            sort(ints, 0, ints.size - 1)
//            endText.text = convert(ints)
//        }
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