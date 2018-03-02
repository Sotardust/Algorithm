package com.dai.algorithm;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.dai.R;
import com.dai.algorithm.fragment.dynamic.LongestCommonSubsequence;
import com.dai.algorithm.fragment.sort.BubbleSortFragment;
import com.dai.algorithm.fragment.sort.HeapSortFragment;
import com.dai.algorithm.fragment.sort.InsertSortFragment;
import com.dai.algorithm.fragment.sort.MergeSortFragment;
import com.dai.algorithm.fragment.sort.QuickSortFragment;
import com.dai.algorithm.fragment.sort.SelectSortFragment;
import com.dai.algorithm.fragment.sort.ShellSortFragment;

/**
 * Created by dai on 2017/5/26.
 */

public class SortActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sort);
        int position = getIntent().getIntExtra("position", -1);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new BubbleSortFragment() ;
                break;
            case 1:
                fragment = new QuickSortFragment() ;
                break;
            case 2:
                fragment = new MergeSortFragment() ;
                break;
            case 3:
                fragment = new ShellSortFragment() ;
                break;
            case 4:
                fragment = new InsertSortFragment() ;
                break;
            case 5:
                fragment = new HeapSortFragment() ;
                break;
            case 6:
                fragment = new SelectSortFragment() ;
                break;
            case 7:
                fragment = new LongestCommonSubsequence() ;
                break;
        }
        transaction.replace(R.id.fragment, fragment).commit();
    }
}
