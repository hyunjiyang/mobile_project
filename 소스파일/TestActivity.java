package com.example.findyourblue;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class TestActivity extends AppCompatActivity {
    private CheckBox one, two, three, four, five,six,seven,eight,nine;// checkboxes you want
    Button btn;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);
        six = findViewById(R.id.six);
        seven = findViewById(R.id.seven);
        eight = findViewById(R.id.eight);
        nine = findViewById(R.id.nine);
        btn = findViewById(R.id.OK);

        one.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isCheckedOrNOT(isChecked);
            }
        });
        two.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isCheckedOrNOT(isChecked);
            }
        });
        three.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isCheckedOrNOT(isChecked);
            }
        });
        four.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isCheckedOrNOT(isChecked);
            }
        });
        five.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isCheckedOrNOT(isChecked);
            }
        });
        six.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isCheckedOrNOT(isChecked);
            }
        });
        seven.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isCheckedOrNOT(isChecked);
            }
        });
        eight.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isCheckedOrNOT(isChecked);
            }
        });
        nine.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isCheckedOrNOT(isChecked);
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (count>=5){
                    AlertDialog.Builder builder = new AlertDialog.Builder(TestActivity.this);
                    builder.setTitle("코로나 블루 알림").setMessage("당신은 코로나 블루 진단 결과 고위험으로 판단되었습니다. \n 전문가의 상담이 필요합니다.\n\n 정신건강 상담전화 : 1577 - 0199");
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                    Toast.makeText(getApplicationContext(), "당신의 증상 수는 "+count + "개로 전문가의 도움이 필요합니다.", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "당신의 증상 수는 "+count + "개로 건강합니다.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void isCheckedOrNOT(boolean isChecked) {
        if (isChecked) {
            count++;
        } else {
            if (count > 0) {
                count--;
            }
        }
    }
}