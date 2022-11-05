package com.example.myfirstprogram;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView result;
    double num1=0, num2=0,res=0;
    char operatorButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = findViewById(R.id.textViewResult);

    }

    public void buttonFunctionNumber(View view) {
        if (view instanceof Button) {
            Button b = (Button) view;
            String str = b.getText().toString();
            result.append(str);
        }
    }

    @SuppressLint("SetTextI18n")
    public void buttonFunctionEquals(View view) {
        if (!(view instanceof Button))
            return;
            num2 = Float.parseFloat(result.getText().toString());
            res = doOperation();
            result.setText(String.valueOf(res));
    }

    @SuppressLint("SetTextI18n")
    public double doOperation() {
        switch (operatorButton) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;

            case 'X':
                return num1 * num2;

            case '/':
                if (num2 != 0) {
                    return (double) num1 / num2;
                } else {
                    result.setText("cannot Dividend by ZERO");
                    return 0;
                }
        }
        return 0;
    }

    public void buttonFunctionOperation(View view) {
        if(!(view instanceof Button))
            return;
        Button b = (Button) view;
        operatorButton = b.getText().toString().charAt(0);
        num1 = Float.parseFloat(result.getText().toString());
        result.setText("");

    }
    public void buttonFunctionClear(View view) {
        result.setText("");
        num1=0;
        num2=0;
        res=0;

    }
}




