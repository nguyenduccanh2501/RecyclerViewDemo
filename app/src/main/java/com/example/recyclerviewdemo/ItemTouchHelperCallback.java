package com.example.recyclerviewdemo;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

public class ItemTouchHelperCallback extends ItemTouchHelper.Callback {
    private ItemTouchListener itemTouchListener;

    public ItemTouchHelperCallback(ItemTouchListener itemTouchListener) {
        this.itemTouchListener = itemTouchListener;
    }

    @Override
    public int getMovementFlags(@NonNull RecyclerView recyclerView,
                                @NonNull RecyclerView.ViewHolder viewHolder) {
        int dragFlag = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
        int swipeFlag = ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;
        return makeMovementFlags(dragFlag, swipeFlag);
    }

    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView,
                          @NonNull RecyclerView.ViewHolder viewHolder,
                          @NonNull RecyclerView.ViewHolder viewHolder1) {
        itemTouchListener.onMove(viewHolder.getAdapterPosition(), viewHolder1.getAdapterPosition());
        return false;
    }

    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
        itemTouchListener.onSwipe(viewHolder.getAdapterPosition(), direction);
    }
}
