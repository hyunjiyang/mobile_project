package com.example.findyourblue;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class VideoActivity extends YouTubeBaseActivity{
    YouTubePlayerView youtubeView;
    Button button, button2;
    YouTubePlayer.OnInitializedListener listener;

    WebView mWebView;
    WebSettings mWebSettings;

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_video);

        button =(Button)findViewById(R.id.button1);
        button2 =(Button)findViewById(R.id.button2);
        youtubeView = (YouTubePlayerView)findViewById(R.id.view1);

        listener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo("cFMIm4Ap5dM");
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                youtubeView.initialize("AIzaSyDsz2HVMOS_z88gj5Ng7PKOZTH3C9YKSDo",listener);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/results?search_query=%EC%BD%94%EB%A1%9C%EB%82%98+%EB%B8%94%EB%A3%A8"));
                startActivity(intent);
            }
        });


    }
}