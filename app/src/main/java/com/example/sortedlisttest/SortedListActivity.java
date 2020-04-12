package com.example.sortedlisttest;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SortedList;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SortedListActivity extends AppCompatActivity {
    private SortedAdapter mSoredAdapter;
    private int count = 10;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sorted_list);
        RecyclerView mRecyclerView = findViewById(R.id.rv);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mSoredAdapter = new SortedAdapter(this);
        // SortedList初始化
        SortedListCallBack mSortedListCallBack = new SortedListCallBack(mSoredAdapter);
        SortedList mSortedList = new SortedList<>(City.class, mSortedListCallBack);

        mSoredAdapter.setSortedList(mSortedList);
        mRecyclerView.setAdapter(mSoredAdapter);
        updateData();//更新方法，初始化+设置
    }

    private void addData() {
        mSoredAdapter.setData(new City(count, "城市" + count, "c"));
        count++;
    }

    private List<City> mList = new ArrayList<>();

    private void updateData() {
        mList.clear();
        mList.add(new City(0, "北京", "b"));
        mList.add(new City(1, "上海", "s"));
        mList.add(new City(2, "广州", "g"));
        mList.add(new City(3, "深圳", "s"));
        mList.add(new City(4, "杭州", "h"));
        mList.add(new City(5, "西安", "x"));
        mList.add(new City(6, "成都", "c"));
        mList.add(new City(7, "武汉", "w"));
        mList.add(new City(8, "南京", "n"));
        mList.add(new City(9, "重庆", "c"));
        mSoredAdapter.setData(mList);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    private Random mRandom = new Random();

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_add:
                addData();
                break;
            case R.id.menu_update:
                updateData();
            case R.id.menu_delete:
                if (mSoredAdapter.getItemCount() > 0) {
                    mSoredAdapter.removeData(mRandom.nextInt(mSoredAdapter.getItemCount()));
                }
                break;
            case R.id.menu_clear:
                mSoredAdapter.clear();
                break;
            default:
                break;
        }
        return true;
    }
}
