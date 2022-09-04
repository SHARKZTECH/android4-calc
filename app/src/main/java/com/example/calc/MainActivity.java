package com.example.calc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    boolean isNewOp=true;
    String op="+";
    String oldNumber="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView=findViewById(R.id.text);
    }

    public void numberEvent(View view) {
        if(isNewOp){
            textView.setText("");
            isNewOp=false;
        }
        String number=textView.getText().toString();

        switch (view.getId()){
            case R.id.btn0:
                number += "0";
                break;
            case R.id.btn1:
                number += "1";
                break;
            case R.id.btn2:
                number += "2";
                break;
            case R.id.btn3:
                number += "3";
                break;
            case R.id.btn4:
                number += "4";
                break;
            case R.id.btn5:
                number += "5";
                break;
            case R.id.btn6:
                number += "6";
                break;
            case R.id.btn7:
                number += "7";
                break;
            case R.id.btn8:
                number += "8";
                break;
            case R.id.btn9:
                number += "9";
                break;
            case R.id.btnDot:
                number += ".";
                break;
            case R.id.btnPlusMin:
                number = "-"+number;
                break;
        }
        textView.setText(number);
    }

    public void opEvent(View view) {
        isNewOp=true;
        oldNumber=textView.getText().toString();
        switch (view.getId()){
            case R.id.btnDiv: op="/"; break;
            case R.id.btnMul: op="*"; break;
            case R.id.btnMin: op="-"; break;
            case R.id.btnPul: op="+"; break;

        }
    }

    public void equlEvent(View view) {
        String newNumber=textView.getText().toString();
        double results=0.0;
        switch (op){
            case "+":
                results=Double.parseDouble(oldNumber) + Double.parseDouble(newNumber);
                break;
            case "-":
                results=Double.parseDouble(oldNumber) - Double.parseDouble(newNumber);
                break;
            case "/":
                results=Double.parseDouble(oldNumber) / Double.parseDouble(newNumber);
                break;
            case "*":
                results=Double.parseDouble(oldNumber) * Double.parseDouble(newNumber);
                break;
             }
        textView.setText(Double.toString(results));
    }

    public void clearEvent(View view) {
        textView.setText("0");
        isNewOp=true;
    }

    public void perEvent(View view) {
        Double no=Double.parseDouble(textView.getText().toString())/100;
        textView.setText(no+"");
        isNewOp=true;
    }
}