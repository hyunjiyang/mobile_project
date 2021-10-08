package com.example.findyourblue;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubePlayer;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class CovidActivity extends AppCompatActivity {
    //크롤링 변수들
    String nums, news;
    TextView textView, textView2;
    //음악 부분
    MusicService mService;

    ServiceConnection conn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mService = ((MusicService.MusicServiceBinder)service).getService();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_covid);

        ImageButton mStart =(ImageButton)findViewById(R.id.start);
        ImageButton mPlay =(ImageButton)findViewById(R.id.play);
        ImageButton mPause =(ImageButton)findViewById(R.id.pause);

        mStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ser = new Intent(CovidActivity.this, MusicService.class);
                startService(ser);
                bindService(ser, conn,BIND_AUTO_CREATE);
            }
        });
        mPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mService.play();
            }
        });
        mPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mService.pause();
            }
        });

        //크롤링 부분
        textView = (TextView) findViewById(R.id.number);
        textView2 = (TextView) findViewById(R.id.news);


        final Bundle bundle = new Bundle();


        new  Thread(){
            @Override
            public void run() {
                Document doc = null;
                try {
                    doc = Jsoup.connect("https://search.naver.com/search.naver?where=nexearch&sm=top_sug.pre&fbm=1&acr=1&acq=zhfhsk&qdt=0&ie=utf8&query=%EC%BD%94%EB%A1%9C%EB%82%98+%ED%99%95%EC%A7%84%EC%9E%90").get();
                    Elements contents = doc.select(".status_today");// 일일확진자 class값 가져오기
                    nums = contents.text();

                    Elements contents2 = doc.select(".news_tit");
                    news = contents2.text();

                    bundle.putString("numbers", nums);     //핸들러를 이용. Thread()에서 가져온 데이터를 메인 쓰레드로 보내기
                    bundle.putString("news1", news);
                    Message msg = handler.obtainMessage();
                    msg.setData(bundle);
                    handler.sendMessage(msg);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
    Handler handler = new Handler(){
        public void handleMessage(Message msg){
            Bundle bundle = msg.getData();
            textView.setText(bundle.getString("numbers"));
            textView2.setText(bundle.getString("news1"));
        }
    };
}
