package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;

    private int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        setupDefault();
        addEvents();
    }

    private void setupDefault() {
        count = 0;
        button1.setText("");
        button2.setText("");
        button3.setText("");
        button4.setText("");
        button5.setText("");
        button6.setText("");
        button7.setText("");
        button8.setText("");
        button9.setText("");
    }

    private void addEvents() {
        buttonClick(button1);
        buttonClick(button2);
        buttonClick(button3);
        buttonClick(button4);
        buttonClick(button5);
        buttonClick(button6);
        buttonClick(button7);
        buttonClick(button8);
        buttonClick(button9);
    }

    private void buttonClick(final Button button) {

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (button.getText().toString().isEmpty()) {
                    count++;
                    button.setText(xOrO(count));
                    if (count>= 5){
                        if (!checkResult()){
                            Intent intent = new Intent(MainActivity.this,StartActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    }
                }
            }
        });
    }

    private boolean checkResult() {
        String string1 = button1.getText().toString();
        String string2 = button2.getText().toString();
        String string3 = button3.getText().toString();
        String string4 = button4.getText().toString();
        String string5 = button5.getText().toString();
        String string6 = button6.getText().toString();
        String string7 = button7.getText().toString();
        String string8 = button8.getText().toString();
        String string9 = button9.getText().toString();
        if (!string1.isEmpty()){
            if (string1.equals(string2)&&string1.equals(string3)) return false;
            if (string1.equals(string4)&&string1.equals(string7)) return false;
            if (string1.equals(string5)&&string1.equals(string9)) return false;
        }
        if (!string2.isEmpty()){
            if (string2.equals(string5)&&string2.equals(string8)) return false;
        }
        if (!string3.isEmpty()){
            if (string3.equals(string5)&&string3.equals(string7)) return false;
            if (string3.equals(string6)&&string3.equals(string9)) return false;
        }
        if (!string4.isEmpty()){
            if (string4.equals(string5)&&string4.equals(string6)) return false;
        }
        if (!string7.isEmpty()){
            if (string7.equals(string8)&&string7.equals(string9)) return false;
        }
        return true;
    }

    private String xOrO(int count){
        if (count % 2 != 0) return "X";
        else return "O";
    }

    private void addControls() {
        button1 = findViewById(R.id.bt_1);
        button2 = findViewById(R.id.bt_2);
        button3 = findViewById(R.id.bt_3);
        button4 = findViewById(R.id.bt_4);
        button5 = findViewById(R.id.bt_5);
        button6 = findViewById(R.id.bt_6);
        button7 = findViewById(R.id.bt_7);
        button8 = findViewById(R.id.bt_8);
        button9 = findViewById(R.id.bt_9);
    }

}
