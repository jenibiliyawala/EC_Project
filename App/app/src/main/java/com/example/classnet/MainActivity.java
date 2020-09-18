package com.example.classnet;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;

import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {
    private WebView mywebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mywebView=(WebView) findViewById(R.id.webview);
        mywebView.setWebViewClient(new WebViewClient());
        mywebView.loadUrl("https://www.j3kram.com/");
        WebSettings webSettings=mywebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }
    public class mywebClient extends WebViewClient{
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon){
            super.onPageStarted(view,url,favicon);
        }
        @Override
        public boolean shouldOverrideUrlLoading(WebView view,String url){
            view.loadUrl(url);
            return true;
        }
    }
    @Override
    public void onBackPressed(){
        if(mywebView.canGoBack()) {
            mywebView.goBack();
        }
        else{
            super.onBackPressed();
        }
    }
}
/*

create
1) Build->Generate Signed Bundle/APK->click
2) Select APK->next
3) create new->click
4) key store path(path to store apk), password(any), confirm(same), password(same), confirm(same), validity(100 year)
5) fill certificate details->click on OK
6) remember password->click on next
7) select release->select both v1 and v2->click on finish

set icon
1) goto res->drawable->new->image asset
2) set asset type to image->select path of image(500*500pixel)
3) resize to fit into google play store
4) click on next->click on finish
5) click on build->generate signed bundle/APK->click on next->click on next->click on finish
6) rename apk ans save it
*/