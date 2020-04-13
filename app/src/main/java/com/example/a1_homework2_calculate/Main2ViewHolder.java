package com.example.a1_homework2_calculate;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Main2ViewHolder extends RecyclerView.ViewHolder {
   private TextView textView;

    public Main2ViewHolder(@NonNull View itemView) {
        super(itemView);
        textView=itemView.findViewById(R.id.vh_text_view);
    }
    public void onBind(String s) {

        textView.setText(s);
    }
}
