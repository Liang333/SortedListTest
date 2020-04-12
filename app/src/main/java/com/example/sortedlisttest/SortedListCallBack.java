package com.example.sortedlisttest;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SortedListAdapterCallback;

/**
 * SortedListCallBack 为SortedListAdapterCallback 的实现类
 * SortedListCallBack 定义了如何排序和如何判断重复项
 */
public class SortedListCallBack extends SortedListAdapterCallback<City> {

    public SortedListCallBack(RecyclerView.Adapter adapter) {
        super(adapter);
    }

    /**
     * 排序条件
     * @param o1
     * @param o2
     * @return
     */
    @Override
    public int compare(City o1, City o2) {
        return o1.getFirstLetter().compareTo(o2.getFirstLetter());
    }

    /**
     * 判断俩对象是否是内容相同
     * @param oldItem
     * @param newItem
     * @return
     */
    @Override
    public boolean areContentsTheSame(City oldItem, City newItem) {
        if (oldItem.getId() != newItem.getId()) {
            return false;
        }
        return oldItem.getCityName().equals(newItem.getCityName());
    }

    /**
     * 判断两对象是否有相同的item:比较getId()
     * @param item1
     * @param item2
     * @return
     */
    @Override
    public boolean areItemsTheSame(City item1, City item2) {
        return item1.getId() == item2.getId();
    }
}
