package com.example.recyclerviewdemo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.ViewHolDer> {
    private List<Person> mPersonList;

    public PersonAdapter(List<Person> mPersonList) {
        this.mPersonList = mPersonList;
    }

    @NonNull
    @Override
    public ViewHolDer onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_person,parent,false);
        return new ViewHolDer(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolDer viewHolder, int position) {
        viewHolder.imagePerson.setImageResource(mPersonList.get(position).getmImage());
        viewHolder.textTen.setText(mPersonList.get(position).getmTen());
    }

    @Override
    public int getItemCount() {
        return mPersonList == null ? 0 : mPersonList.size();
    }

    public class ViewHolDer extends RecyclerView.ViewHolder{
        ImageView imagePerson;
        TextView textTen;
        public ViewHolDer(@NonNull View itemView) {
            super(itemView);
            imagePerson = itemView.findViewById(R.id.image_person);
            textTen = itemView.findViewById(R.id.text_ten);
        }
    }

    public void onMove(int fromPosition, int toPosition) {
        if (fromPosition < toPosition) {
            for (int i = fromPosition; i < toPosition; i++) {
                Collections.swap(mPersonList, i, i + 1);
            }
        } else {
            for (int i = fromPosition; i > toPosition; i--) {
                Collections.swap(mPersonList, i, i - 1);
            }
        }
        notifyItemMoved(fromPosition, toPosition);
    }

    public void onSwipe(int position, int direction) {
        mPersonList.remove(position);
        notifyItemRemoved(position);
    }
}
