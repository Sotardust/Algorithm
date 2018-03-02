package com.dai.algorithm.fragment;

import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.TextView;

import com.dai.R;

/**
 * Created by dai on 2017/7/3.
 */

public class BaseFragment extends Fragment {

    public TextView sortTitle;
    public TextView start;
    public TextView initText;
    public TextView endText;

    public void initView(View view) {
        sortTitle = (TextView) view.findViewById(R.id.sort);
        start = (TextView) view.findViewById(R.id.start);
        initText = (TextView) view.findViewById(R.id.init_text);
        endText = (TextView) view.findViewById(R.id.sort_end_text);
    }

    public String convert(int[] ints) {
        StringBuilder sb = new StringBuilder();
        for (int value : ints) {
            sb.append(value).append(",");
        }
        return sb.toString();
    }
}
