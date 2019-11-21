package com.ssc.itemtouchhelper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import com.ssc.itemtouchhelper.adapter.ListDragAdapter;
import com.ssc.itemtouchhelper.bean.DargBean;
import com.ssc.itemtouchhelper.callback.ItemDragHelperCallBack;
import com.ssc.itemtouchhelper.listener.OnItemDragListener;

import java.util.List;

/**
 * 长按拖拽
 */
public class LongDragActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private String json = "[{\n" +
            "\t\"dragStatus\": 1,\n" +
            "\t\"text\": \"今日头条\"\n" +
            "},{\n" +
            "\t\"dragStatus\": 1,\n" +
            "\t\"text\": \"知乎\"\n" +
            "},{\n" +
            "\t\"dragStatus\": 2,\n" +
            "\t\"text\": \"网易新闻\"\n" +
            "},{\n" +
            "\t\"dragStatus\": 2,\n" +
            "\t\"text\": \"腾讯新闻\"\n" +
            "},{\n" +
            "\t\"dragStatus\": 2,\n" +
            "\t\"text\": \"稀土掘金\"\n" +
            "},{\n" +
            "\t\"dragStatus\": 1,\n" +
            "\t\"text\": \"简书\"\n" +
            "},{\n" +
            "\t\"dragStatus\": 1,\n" +
            "\t\"text\": \"美团\"\n" +
            "},{\n" +
            "\t\"dragStatus\": 2,\n" +
            "\t\"text\": \"饿了么\"\n" +
            "},{\n" +
            "\t\"dragStatus\": 1,\n" +
            "\t\"text\": \"新浪微博\"\n" +
            "},{\n" +
            "\t\"dragStatus\": 1,\n" +
            "\t\"text\": \"微信\"\n" +
            "},{\n" +
            "\t\"dragStatus\": 1,\n" +
            "\t\"text\": \"高德地图\"\n" +
            "},{\n" +
            "\t\"dragStatus\": 1,\n" +
            "\t\"text\": \"百度地图\"\n" +
            "},{\n" +
            "\t\"dragStatus\": 1,\n" +
            "\t\"text\": \"支付宝\"\n" +
            "},{\n" +
            "\t\"dragStatus\": 1,\n" +
            "\t\"text\": \"英雄联盟\"\n" +
            "},{\n" +
            "\t\"dragStatus\": 1,\n" +
            "\t\"text\": \"绝地求生\"\n" +
            "},{\n" +
            "\t\"dragStatus\": 1,\n" +
            "\t\"text\": \"荒野行动\"\n" +
            "},{\n" +
            "\t\"dragStatus\": 1,\n" +
            "\t\"text\": \"饥荒\"\n" +
            "},{\n" +
            "\t\"dragStatus\": 1,\n" +
            "\t\"text\": \"守望先锋\"\n" +
            "},{\n" +
            "\t\"dragStatus\": 1,\n" +
            "\t\"text\": \"王者荣耀\"\n" +
            "},{\n" +
            "\t\"dragStatus\": 1,\n" +
            "\t\"text\": \"QQ飞车\"\n" +
            "}]";
    private ListDragAdapter adapter;
    private List<DargBean> dargBeanList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_long_drag);

        recyclerView = findViewById(R.id.recyclerView);
        dargBeanList = DargBean.arrayDargBeanFromData(json);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 4));
        adapter = new ListDragAdapter(this, dargBeanList);
        recyclerView.setAdapter(adapter);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new ItemDragHelperCallBack(new OnItemDragListener() {

            @Override
            public void onItemMove(int startPos, int endPos) {
                adapter.itemMove(startPos, endPos);
            }
        }));
        //关联RecyclerView
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }
}
