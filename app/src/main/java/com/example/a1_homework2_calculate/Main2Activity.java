package com.example.a1_homework2_calculate;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import java.util.ArrayList;

import static android.content.Intent.EXTRA_TEXT;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {
    TextView infoTextView;
    static int TEXT_KEY = 2;
    private RecyclerView recyclerView;
    private Main2Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<String> history;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
//        infoTextView = findViewById(R.id.text);
//        if (savedInstanceState != null) {
//            save_result = savedInstanceState.getString("save_result");
//            infoTextView.setText(save_result);
//                    }
// Применение Recycler View списка
        recyclerView = findViewById(R.id.recycler_view);
        layoutManager = new LinearLayoutManager(this);
        adapter = new Main2Adapter();
        history = new ArrayList<>();
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

//    @Override
//    public void onSaveInstanceState(Bundle outState) {
//        super.onSaveInstanceState(outState);
//        outState.putString("save_result", recyclerView.getText().toString());
//    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.open:
                Intent intent = new Intent(Main2Activity.this, MainActivity.class);
                startActivityForResult(intent, TEXT_KEY);

                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(adapter);

                break;
            case R.id.send:
                if(history.toString()!=null){
                    Intent intent1 = new Intent();
                    intent1.setAction(Intent.ACTION_SEND);
                    intent1.putExtra(EXTRA_TEXT,"Здравствуйте Абай! Мое ДЗ сделано, результат: "+ history.toString());
                    intent1.setType("text/plain");
                    startActivity(intent1);
                }
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 2 && resultCode == RESULT_OK && data != null) {
            history.add(0,data.getStringExtra("resultat"));
            adapter.upDate(history);
            }
        }
    }









