package com.dai.algorithm;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dai.R;
import com.dai.library.util.BaseRecyclerAdapter;

/**
 * Created by dai on 2017/5/26.
 */

public class SortAdapter extends BaseRecyclerAdapter<String> {

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position, String data) {
        if (viewHolder instanceof SortViewHolder) {
            ((SortViewHolder) viewHolder).textView.setText(data);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sort, parent, false);
        return new SortViewHolder(view);
    }

    private class SortViewHolder extends RecyclerView.ViewHolder {

        TextView textView;

        private SortViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.item_text);
        }
    }
}
