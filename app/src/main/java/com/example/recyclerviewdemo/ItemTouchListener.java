package com.example.recyclerviewdemo;

public interface ItemTouchListener {
    void onMove(int oldPosition, int newPosition);
    void onSwipe(int position, int direction);
}
