package com.example.findyourblue;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Random;

public class DiaryActivity extends AppCompatActivity {
    private EditText inputForm;
    private TextView result;
    private Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary);

        init();
    }
    private void init(){
        inputForm = findViewById(R.id.input);
        result = findViewById(R.id.result);
        save = findViewById(R.id.save);
        buttonAction();
    }
    private void buttonAction(){
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentData = inputForm.getText().toString();
                String resultData = null;
                //사용자에게 맞는 위로의 답변 출력
                if ("안녕".equals(currentData)){
                    resultData = "안녕 송이야";
                }else if ("".equals(currentData)){
                    resultData = "오늘 하루는 어땠어? 아주 짧은 말도 좋아!";
                }else{
                    resultData = Selectanswer();  // 다양한 위로의 말 중 랜덤 출력
                }

                result.setText("당신의 한줄 : " +currentData+ "\n\n\n" +"[  "+ resultData +"  ]");
            }
        });
    }
    private String Selectanswer(){
        String[] answerlist = {"넌 너무 소중해", "너가 있어 난 너무 기뻐", "내일은 소소한 행복이 기다리고 있어",
                " 넌 대단해", "사랑해", "넌 존재만으로도 너무 귀중해"};
        Random random = new Random();
        String select = answerlist[random.nextInt(answerlist.length)];
        return select;
    }
}