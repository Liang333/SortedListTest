package com.example.sortedlisttest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SortedList;

import java.util.List;

/**
 * RecyclerView的强大无人不知，它封装了ViewHolder，便于我们回收复用；
 * 配合LayoutManager、ItemDecoration、ItemAnimator 便于制定各种列表效果。
 * SortedList是排序列表，它适用于列表有序且不重复的场景。
 * 并且SortedList会帮助比较数据的差异，定向刷新数据。而不是简单粗暴的notifyDataSetChanged()。
 * SortedList适配器 传入SortedListCallBack中，其可实现排序和判断重复
 */
public class SortedAdapter extends RecyclerView.Adapter<SortedAdapter.ViewHolder> {

    //数据源使用SortedList
    private SortedList<City> mSortedList;
    private LayoutInflater mInflater;

    //静态内部类，用类名直接调用
    // RecyclerView.Adapter<SortedAdapter.ViewHolder>中 使用为传入的形参
    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView mTvName;

        ViewHolder(View itemView) {
            super(itemView);
            mTvName = itemView.findViewById(R.id.tv_name);
        }
    }

    // 构造方法
    public SortedAdapter(Context mContext) {
        mInflater = LayoutInflater.from(mContext);
    }

    public void setSortedList(SortedList<City> mSortedList) {
        this.mSortedList = mSortedList;
    }

    /**
          * 批量更新操作，例如：
          * <pre>
          *     mSortedList.beginBatchedUpdates();
          *     try {
          *         mSortedList.add(item1)
          *         mSortedList.add(item2)
          *         mSortedList.remove(item3)
          *         ...
          *     } finally {
          *         mSortedList.endBatchedUpdates();
          *     }
          * </pre>
         * */

    public void setData(City mData){
        mSortedList.beginBatchedUpdates();
        mSortedList.addAll(mData);
        mSortedList.endBatchedUpdates();
    }

    public void setData(List<City> mData) {
        mSortedList.beginBatchedUpdates();
        mSortedList.addAll(mData);
        mSortedList.endBatchedUpdates();
    }

    public void removeData(int index) {
        mSortedList.removeItemAt(index);
    }

    public void clear() {
        mSortedList.clear();
    }


    @Override
    @NonNull
    public SortedAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(mInflater.inflate(R.layout.item_test, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SortedAdapter.ViewHolder holder, final int position) {
        City bean = mSortedList.get(position);
        holder.mTvName.setText(bean.getCityName() + "(" + bean.getFirstLetter() + ")");
    }

    @Override
    public int getItemCount() {
        return mSortedList.size();
    }

}
