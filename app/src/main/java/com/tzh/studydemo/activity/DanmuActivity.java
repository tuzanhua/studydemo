package com.tzh.studydemo.activity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.tzh.studydemo.R;

public class DanmuActivity extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danmu);
        webView = findViewById(R.id.webview);
        WebSettings setting = webView.getSettings();
        setting.setJavaScriptEnabled(true);

        /**设置自适应屏幕，两者合用**/
        //将图片调整到适合webview的大小
        setting.setUseWideViewPort(true);
        // 缩放至屏幕的大小
        setting.setLoadWithOverviewMode(true);

        /**缩放操作**/
        // 是否支持画面缩放，默认不支持
        setting.setBuiltInZoomControls(true);
        setting.setSupportZoom(true);
        // 是否显示缩放图标，默认显示
        setting.setDisplayZoomControls(false);
        // 设置网页内容自适应屏幕大小
        setting.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);

        /**设置允许JS弹窗**/
        setting.setJavaScriptCanOpenWindowsAutomatically(true);
        setting.setDomStorageEnabled(true);

        /**关闭webview中缓存**/
        setting.setCacheMode(WebSettings.LOAD_NO_CACHE);
        /**设置可以访问文件 **/
        setting.setAllowFileAccess(true);
        setting.setAllowFileAccessFromFileURLs(true);
        setting.setAllowUniversalAccessFromFileURLs(true);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                webView.loadUrl(url);
                return true;
            }
        });

        webView.loadUrl("http://qzs.qq.com/open/yyb/yyb_xy/xieyi.html");
    }

    public void loadurlLocalMethod(final WebView webView, final String url) {
        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });
    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
