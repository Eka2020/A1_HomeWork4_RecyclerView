package com.example.a1_homework2_calculate;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView result_field;
    TextView operation;
    EditText number_field;
    Double operand = null;
    String lastOperation = "=";
    String result_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result_field = (TextView) findViewById(R.id.result_field);
        number_field = (EditText) findViewById(R.id.number_field);
        operation = (TextView) findViewById(R.id.operation);
    }

    public void Save(View view) {
        result_text =result_field.getText().toString();
        Intent intent= new Intent();
        intent.putExtra("resultat",result_text);
        setResult(RESULT_OK, intent);
        finish();
    }

    public void onNumberClick(View view) {
                Button button = (Button) view;
                number_field.append(button.getText());

                if (lastOperation.equals("=") && operand != null) {
                    operand = null;
                }
            }
            public void onOperationClick(View view) {
                Button button = (Button) view;
                String op = button.getText().toString();
                String number = number_field.getText().toString();
                if (number.length() > 0) {
                    number = number.replace('.', '.');
                    try {
                        performOperation(Double.valueOf(String.valueOf(number)), op);
                    } catch (NumberFormatException ex) {
                        number_field.setText("");
                    }
                }
                lastOperation = op;
                operation.setText(lastOperation);

            }
            private void performOperation(Double number, String operation) {
                if (operand == null) {
                    operand = number;
                } else {
                    if (lastOperation.equals("=")) {
                        lastOperation = operation;
                    }
                    switch (lastOperation) {
                        case "=":
                            operand = number;
                            break;
                        case "/":
                            if (number == 0) {
                                operand = 0.0;
                            } else {
                                operand /= number;
                            }
                            break;
                        case "*":
                            operand *= number;
                            break;
                        case "+":
                            operand += number;
                            break;
                        case "-":
                            operand -= number;
                            break;
                    }
                }
                result_field.setText(operand.toString());
                number_field.setText("");
            }

            @Override
            protected void onSaveInstanceState(Bundle outState) {
                outState.putString("operation", lastOperation);
                if (operand != null)
                    outState.putDouble("operand", operand);
                super.onSaveInstanceState(outState);
            }
            @Override
            protected void onRestoreInstanceState(Bundle savedInstanceState) {
                super.onRestoreInstanceState(savedInstanceState);
                lastOperation = savedInstanceState.getString("operation");
                operand = savedInstanceState.getDouble("operand");
                operation.setText(lastOperation);
                result_field.setText(operand.toString());
            }
}
