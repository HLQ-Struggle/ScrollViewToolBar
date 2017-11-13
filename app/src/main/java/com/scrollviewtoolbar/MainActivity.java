package com.scrollviewtoolbar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.scrollviewtoolbar.listener.TranslucentListener;
import com.scrollviewtoolbar.weight.MyScrollView;

/**
 * create by heliquan at 2017年11月13日
 */
public class MainActivity extends AppCompatActivity implements TranslucentListener {

    private Toolbar mToolBar;
    private MyScrollView mScrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolBar = findViewById(R.id.id_toolbar);
        setSupportActionBar(mToolBar);
        mScrollView = findViewById(R.id.id_scrollView);
        mScrollView.setTranslucentListener(this);
    }

    @Override
    public void onTranslucent(float alpha) {
        mToolBar.setAlpha(alpha);
    }
}
