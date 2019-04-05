package com.example.recyclerviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerPerson;
    private List<Person> mPersonList;
    private PersonAdapter mPersonAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    public void initView(){
        mRecyclerPerson = findViewById(R.id.recycler_view_person);
        mPersonList = new ArrayList<>();
        mPersonList.add(new Person(R.drawable.ic_launcher_background, "Nguyễn Nam"));
        mPersonList.add(new Person(R.drawable.ic_launcher_background, "Tuấn Minh"));
        mPersonList.add(new Person(R.drawable.ic_launcher_background, "Văn Nghĩa"));
        mPersonList.add(new Person(R.drawable.ic_launcher_background, "Trần Anh"));
        mPersonList.add(new Person(R.drawable.ic_launcher_background, "Nguyễn Anh"));
        mPersonList.add(new Person(R.drawable.ic_launcher_background, "Văn Anh"));
        mPersonList.add(new Person(R.drawable.ic_launcher_background, "Đào Anh"));
        mPersonList.add(new Person(R.drawable.ic_launcher_background, "Tuấn Anh"));
        mPersonAdapter = new PersonAdapter(mPersonList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerPerson.setLayoutManager(layoutManager);
        mRecyclerPerson.setAdapter(mPersonAdapter);
        addItemTouchCallback(mRecyclerPerson);
    }

    private void addItemTouchCallback(RecyclerView recyclerView) {
        ItemTouchHelper.Callback callback = new ItemTouchHelperCallback(new ItemTouchListener() {
            @Override
            public void onMove(int oldPosition, int newPosition) {
                mPersonAdapter.onMove(oldPosition, newPosition);
            }

            @Override
            public void onSwipe(int position, int direction) {
                mPersonAdapter.onSwipe(position, direction);
            }
        });
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(callback);
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }
}
