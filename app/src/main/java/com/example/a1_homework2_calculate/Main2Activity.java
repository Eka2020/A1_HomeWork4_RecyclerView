package com.example.a1_homework2_calculate;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {
    TextView infoTextView;
    String save_result;
    static int TEXT_KEY = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        infoTextView = findViewById(R.id.text);
        if (savedInstanceState != null) {
            save_result = savedInstanceState.getString("save_result");
            infoTextView.setText(save_result);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("save_result", infoTextView.getText().toString());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == TEXT_KEY) {
            if (resultCode == RESULT_OK) {
                String result = data.getStringExtra("resultat");
                infoTextView.setText(result);
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.open:
                Intent intent = new Intent(Main2Activity.this, MainActivity.class);
                startActivityForResult(intent, TEXT_KEY);
                break;
            case R.id.send:
                Intent intent1 = new Intent();
                intent1.setAction(Intent.ACTION_SEND);
                intent1.putExtra(Intent.EXTRA_TEXT, "Здравствуйте Абай! Мое ДЗ сделано, результат: "+ infoTextView.getText().toString());
                intent1.setType("text/plain");
                if (intent1.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent1);
                }
                break;
        }
    }
}






