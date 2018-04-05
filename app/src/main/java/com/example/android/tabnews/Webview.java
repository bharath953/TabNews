package com.example.android.tabnews;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by bharath on 05-Apr-18.
 */

public  class Webview extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        String url=getIntent().getStringExtra("url");
        webView=findViewById(R.id.webview);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(url);
        if(webView.canGoBack()){
            webView.goBack();
        }
    }

    public void OnBack(View view){
        if(webView.canGoBack()){
            webView.goBack();
        }
    }
    public void Onforward(View view){
        if(webView.canGoForward()){
            webView.goForward();
        }
    }
}
