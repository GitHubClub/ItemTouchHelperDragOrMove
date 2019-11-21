package com.ssc.itemtouchhelper.callback;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.ssc.itemtouchhelper.listener.OnItemDragListener;

import static android.support.v7.widget.helper.ItemTouchHelper.ACTION_STATE_IDLE;

/**
 * Created by ssc on 2018/2/24.
 * 长按拖拽
 */

public class ItemDragHelperCallBack extends ItemTouchHelper.Callback {

    private OnItemDragListener onItemDragListener;

    public ItemDragHelperCallBack(OnItemDragListener onItemDragListener) {
        this.onItemDragListener = onItemDragListener;
    }

    /**
     * 返回可以滑动的方向
     *
     * @param recyclerView
     * @param viewHolder
     * @return
     */
    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        if (viewHolder.getItemViewType() == 1) {
            return makeMovementFlags(ACTION_STATE_IDLE, 0);
        }
        RecyclerView.LayoutManager manager = recyclerView.getLayoutManager();
        int dragFlags;
        if (manager instanceof GridLayoutManager || manager instanceof StaggeredGridLayoutManager) {
            //网格布局管理器允许上下左右拖动
            dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN | ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;
        } else {
            //其他布局管理器允许上下拖动
            dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
        }
        return makeMovementFlags(dragFlags, 0);
    }

    /**
     * 拖拽到新位置时候的回调方法
     *
     * @param recyclerView
     * @param viewHolder
     * @param target
     * @return
     */
    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        if (viewHolder.getItemViewType() == 1) {
            return false;
        }
        //不同Type之间不允许移动
        if (viewHolder.getItemViewType() != target.getItemViewType()) {
            return false;
        }
        if (onItemDragListener != null) {
            onItemDragListener.onItemMove(viewHolder.getAdapterPosition(), target.getAdapterPosition());
        }
        return true;
    }

    /**
     * 是否支持长按拖拽，默认值为true
     *
     * @return
     */
    @Override
    public boolean isLongPressDragEnabled() {
        return super.isLongPressDragEnabled();
    }

    /**
     * 当用户左右滑动的时候执行的方法
     *
     * @param viewHolder
     * @param direction
     */
    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {

    }

    public void setOnItemDragListeber(OnItemDragListener onItemDragListener) {
        this.onItemDragListener = onItemDragListener;
    }

}
