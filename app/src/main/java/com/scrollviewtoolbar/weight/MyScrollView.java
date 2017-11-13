package com.scrollviewtoolbar.weight;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

import com.scrollviewtoolbar.listener.TranslucentListener;

/**
 * Created by HLQ on 2017/11/13 0013.
 */

public class MyScrollView extends ScrollView {

    private TranslucentListener mTranslucentListener;

    public void setTranslucentListener(TranslucentListener translucentListener) {
        this.mTranslucentListener = translucentListener;
    }

    public MyScrollView(Context context) {
        this(context, null);
    }

    public MyScrollView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public MyScrollView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if (mTranslucentListener != null) {
            // 获取ScrollView滑出高度
            int scrollY = getScrollY();
            // 获取屏幕高度
            int screenHeight = getContext().getResources().getDisplayMetrics().heightPixels;
            if (scrollY <= screenHeight / 3f) {
                // alpha = 滑动高度/（screenHeight/3f）
                mTranslucentListener.onTranslucent(1 - scrollY / (screenHeight / 3f));
            }
        }
    }
}
