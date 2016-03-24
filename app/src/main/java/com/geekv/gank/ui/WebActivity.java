package com.geekv.gank.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.geekv.gank.R;

public class WebActivity extends AppCompatActivity {
    WebView webView;
    TextView tvToolbarTitle;
    ProgressBar pb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_web);
        setSupportActionBar(toolbar);
        webView= (WebView) findViewById(R.id.webview);
        pb= (ProgressBar) findViewById(R.id.pb);
        pb.setMax(100);
        tvToolbarTitle= (TextView) findViewById(R.id.tv_toolbar);
        Intent intent=getIntent();
        String url=intent.getStringExtra("url");
        String name=intent.getStringExtra("name");

        tvToolbarTitle.setText(name);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setSupportZoom(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.setWebChromeClient(new WebViewClient());
        webView.loadUrl(url);
    }

    private class WebViewClient extends WebChromeClient {
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            pb.setProgress(newProgress);
            if(newProgress==100){
                pb.setVisibility(View.GONE);
            }
            super.onProgressChanged(view, newProgress);
        }
    }

}
