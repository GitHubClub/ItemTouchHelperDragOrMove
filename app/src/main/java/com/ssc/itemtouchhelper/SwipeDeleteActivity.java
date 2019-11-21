package com.ssc.itemtouchhelper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.ssc.itemtouchhelper.adapter.ListSwipeAdapter;
import com.ssc.itemtouchhelper.callback.ItemSwipeHelperCallBack;
import com.ssc.itemtouchhelper.listener.OnItemSwipeListener;

import java.util.ArrayList;
import java.util.List;

public class SwipeDeleteActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private String[] array = {"今日头条", "知乎", "网易新闻", "腾讯新闻", "稀土掘金", "简书", "美团", "饿了么",
            "新浪微博", "微信", "高德地图", "百度地图", "支付宝", "英雄联盟", "绝地求生", "荒野行动",
            "饥荒", "守望先锋", "王者荣耀", "QQ飞车"};
    private List<String> list;
    private ListSwipeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_delete);

        recyclerView = findViewById(R.id.recyclerView);
        list = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            list.add(array[i]);
        }

        adapter = new ListSwipeAdapter(this, list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new ItemSwipeHelperCallBack(new OnItemSwipeListener() {
            @Override
            public void onItemSwiped(int pos) {
                if (list.size() > pos) {
                    list.remove(pos);
                    adapter.notifyItemRemoved(pos);
                }
            }
        }));
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }
}
