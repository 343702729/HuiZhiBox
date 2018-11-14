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

//        getPPTFileIntent(new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath() + "/" + "test.pptx"));
        webView.setWebViewClient(new AppWebViewClients());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setUseWideViewPort(true);
        webView.loadUrl("http://view.officeapps.live.com/op/view.aspx?src=http://testyayinclear-10049504.file.myqcloud.com/DownloadCenterHH/YC00100025/%E6%98%86%E5%B1%B1%E5%86%9C%E6%9D%91%E5%95%86%E4%B8%9A%E9%93%B6%E8%A1%8C-%E5%95%86%E6%88%B7%E4%BF%A1%E6%81%AF_7598596334064210577.xls");
    }

    public static Intent getPPTFileIntent(File file){
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        Uri uri = Uri.fromFile(file);
        intent.setDataAndType(uri, "application/vnd.ms-powerpoint");
        return intent;
    }


    public class AppWebViewClients extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            // TODO Auto-generated method stub
            view.loadUrl(url);
            return true;
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            // TODO Auto-generated method stub
            super.onPageFinished(view, url);
        }
    }

}
