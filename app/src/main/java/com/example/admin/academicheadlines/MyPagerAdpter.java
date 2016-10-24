package com.example.admin.academicheadlines;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by ShaWei on 2016/10/23.
 */
public class MyPagerAdpter extends PagerAdapter {

    private List<View> viewList;
    private List<String> titleList;

    public MyPagerAdpter(List<View> viewList, List<String> titleList) {
        this.viewList = viewList;
        this.titleList = titleList;
    }

    @Override
    public int getCount() {
        return viewList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(viewList.get(position));
        return viewList.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(viewList.get(position));
    }

    //设置页卡标题
    @Override
    public CharSequence getPageTitle(int position) {
        return titleList.get(position);
    }
}
