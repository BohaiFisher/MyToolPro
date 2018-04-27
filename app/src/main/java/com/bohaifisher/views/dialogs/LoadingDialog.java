package com.bohaifisher.views.dialogs;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.widget.TextView;

import com.bohaifisher.mytoolpro.R;

/**
 * Created by Sean on 2018/4/27.
 */

public class LoadingDialog extends AlertDialog {

    private LVCircularRing mLoadingView;
    private TextView mTvLoading;
    private String mShowHint;

    public LoadingDialog(Context context, String showHint) {
        super(context, R.style.Theme_Loading_Dialog);
        this.mShowHint = showHint;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_loading);

        //点击imageview外侧区域，动画不会消失
        setCanceledOnTouchOutside(false);
        mLoadingView = (LVCircularRing) findViewById(R.id.lv_circularring);
        // 页面中显示文本
        mTvLoading = (TextView) findViewById(R.id.tv_loading);
        // 显示文本
        mTvLoading.setText(mShowHint);

    }

    /**
     * 在AlertDialog的 onStart() 生命周期里面执行开始动画
     */
    @Override
    protected void onStart() {
        super.onStart();
        mLoadingView.startAnim();
    }

    /**
     * 在AlertDialog的onStop()生命周期里面执行停止动画
     */
    @Override
    protected void onStop() {
        super.onStop();
        mLoadingView.stopAnim();
    }
}
