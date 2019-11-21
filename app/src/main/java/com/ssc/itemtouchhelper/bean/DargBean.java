package com.ssc.itemtouchhelper.bean;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * author Song
 * create 2019/11/21
 * Desc
 */
public class DargBean {

    /**
     * dragStatus : 1
     * text : 百度地图
     */

    private int dragStatus;
    private String text;

    public static List<DargBean> arrayDargBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<DargBean>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public int getDragStatus() {
        return dragStatus;
    }

    public void setDragStatus(int dragStatus) {
        this.dragStatus = dragStatus;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
