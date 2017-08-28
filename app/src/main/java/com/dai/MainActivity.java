package com.dai;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.dai.library.util.BaseRecyclerAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        ArrayList<String> data = new ArrayList<>();
        data.add("冒泡排序");
        data.add("快速排序");
        data.add("归并排序");
        data.add("希尔排序");
        data.add("插入排序");
        data.add("堆排序");
        data.add("选择排序");
        data.add("动态规划");
        data.add("二分查找");

        SortAdapter sortAdapter = new SortAdapter();
        sortAdapter.setData(data);

        recyclerView.setAdapter(sortAdapter);
        sortAdapter.setOnItemClickLister(new BaseRecyclerAdapter.OnItemClickLister<String>() {
            @Override
            public void onItemClick(int position, String data) {
                Toast.makeText(getApplicationContext(), data, Toast.LENGTH_SHORT).show();
                System.out.println("position = " + position);
                Intent intent = new Intent(MainActivity.this, SortActivity.class);
                intent.putExtra("position", position);
                startActivity(intent);
            }
        });

    }
}
