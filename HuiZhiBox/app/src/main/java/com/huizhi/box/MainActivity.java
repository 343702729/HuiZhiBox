package com.huizhi.box;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.huizhi.box.activity.BaseActivity;
import com.huizhi.box.util.StatusBarCompat;

import java.io.File;

import butterknife.BindView;

public class MainActivity extends BaseActivity {
    @BindView(R.id.webview)
    WebView webView;

    @Override
    public int layoutView() {
        return R.layout.activity_main;
    }

    @Override
    public void initview() {
        super.initview();
        StatusBarCompat.compat(this, getResources().getColor(R.color.base_top));

    }

}
