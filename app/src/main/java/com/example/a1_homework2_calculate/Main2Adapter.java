package com.example.a1_homework2_calculate;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class Main2Adapter extends RecyclerView.Adapter<Main2ViewHolder> {
    private ArrayList<String> data;

    public Main2Adapter() {
        data = new ArrayList<>();
    }

    @NonNull
    @Override
    public Main2ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        int viewHoldersCounter = 0;
        Log.d("ololo", "OnCreateViewHolder- " + ++viewHoldersCounter);
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.view_holder_main2, parent,false);
        Main2ViewHolder viewHolder=new Main2ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull Main2ViewHolder holder, int position) {
        Log.d("ololo", "onBindViewHolder" +" - "+ position);
        holder.onBind(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void upDate(ArrayList<String> history) {
        data = history;
        notifyDataSetChanged();
    }
}

