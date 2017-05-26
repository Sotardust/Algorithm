package com.dai;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.dai.fragment.BubbleSortFragment;
import com.dai.fragment.HeapSortFragment;
import com.dai.fragment.InsertSortFragment;
import com.dai.fragment.MergeSortFragment;
import com.dai.fragment.QuickSortFragment;
import com.dai.fragment.SelectSortFragment;
import com.dai.fragment.ShellSortFragment;

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
        }
        transaction.replace(R.id.fragment, fragment).commit();
    }
}
