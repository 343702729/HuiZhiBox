package com.huizhi.box;

import com.huizhi.box.activity.BaseActivity;
import com.huizhi.box.util.StatusBarCompat;

public class MainActivity extends BaseActivity {

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
