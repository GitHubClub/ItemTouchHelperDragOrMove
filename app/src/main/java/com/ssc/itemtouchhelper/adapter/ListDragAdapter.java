package com.ssc.itemtouchhelper.adapter;

import android.app.Service;
import android.content.Context;
import android.os.Vibrator;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ssc.itemtouchhelper.R;
import com.ssc.itemtouchhelper.bean.DargBean;

import java.util.Collections;
import java.util.List;

/**
 * Created by ssc on 2018/2/24.
 */

public class ListDragAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private List<DargBean> list;
    private int ITEM_TITLE = 1;
    private int ITEM_CONTENT = 2;

    public ListDragAdapter(Context context, List<DargBean> list) {
        this.mContext = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        if (viewType == ITEM_TITLE) {
            view = LayoutInflater.from(mContext).inflate(R.layout.item_list_drag2, parent, false);
        } else {
            view = LayoutInflater.from(mContext).inflate(R.layout.item_list_drag, parent, false);
        }
        return new MyDragViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyDragViewHolder mHolder = (MyDragViewHolder) holder;
        mHolder.tvTag.setText(list.get(position).getText());
        mHolder.llItem.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                //获取系统震动服务
                Vibrator vib = (Vibrator) mContext.getSystemService(Service.VIBRATOR_SERVICE);
                vib.vibrate(150);
                return false;
            }
        });
    }

    @Override
    public int getItemViewType(int position) {
        if (list.get(position).getDragStatus() == 2) {
            return ITEM_TITLE;
        } else {
            return ITEM_CONTENT;
        }
    }

    /**
     * item拖动后数据交换及动画执行
     *
     * @param fromPosition
     * @param toPosition
     */
    public void itemMove(int fromPosition, int toPosition) {

        Collections.swap(list, fromPosition, toPosition);//数据更换

        notifyItemMoved(fromPosition, toPosition);//执行动画

        notifyItemRangeChanged(Math.min(fromPosition, toPosition), Math.abs(fromPosition - toPosition) + 1);//受影响的itemd都刷新下

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class MyDragViewHolder extends RecyclerView.ViewHolder {

        private TextView tvTag;
        private LinearLayout llItem;

        public MyDragViewHolder(View itemView) {
            super(itemView);
            tvTag = itemView.findViewById(R.id.tv_tag);
            llItem = itemView.findViewById(R.id.ll_item);
        }
    }
}
