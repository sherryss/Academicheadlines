package com.example.admin.academicheadlines;

import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class FollowActivity extends AppCompatActivity {

    private List<View>viewList;
    private ViewPager pager;
    private PagerTabStrip tab;
    private List<String>titleList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_follow);
        viewList = new ArrayList<View>();

        View view1 = View.inflate(this, R.layout.people, null);
        View view2 = View.inflate(this, R.layout.topic, null);
        View view3 = View.inflate(this, R.layout.magazine, null);

        viewList.add(view1);
        viewList.add(view2);
        viewList.add(view3);
        //为ViewPager页卡设置标题
        titleList = new ArrayList<String>();
        titleList.add("关注人");
        titleList.add("关注话题");
        titleList.add("关注期刊");

        //初始化ViewPager
        pager = (ViewPager) findViewById(R.id.pager);

        //创建适配器
        MyPagerAdpter adapter = new MyPagerAdpter(viewList, titleList);

        //Viewpager加载适配器
        pager.setAdapter(adapter);
    }
}
