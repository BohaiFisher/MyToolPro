package com.bohaifisher.views.dialogs;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.bohaifisher.mytoolpro.R;

/**
 * Created by Sean on 2018/4/27.
 */

public class LogoutDialog extends Dialog {

    private Context mContext;
    private TextView mTvCancel;
    private TextView mTvConfirm;
    private TextView mTvContent;
    private OnClickListener mOnClickListener;
    private String mContent = "";

    public LogoutDialog(Context context, String content) {
        super(context, R.style.Theme_Dialog_In_Center);
        this.mContext = context;
        this.mContent = content;
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window window = getWindow();
        window.setGravity(Gravity.CENTER);
        setContentView(R.layout.dialog_logout);
        WindowManager windowManager = ((Activity) mContext).getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.width = display.getWidth() * 4 / 5; // 设置dialog宽度为屏幕的4/5
        getWindow().setAttributes(lp);
        setCanceledOnTouchOutside(true);// 点击Dialog外部消失
        mTvContent = (TextView) findViewById(R.id.tv_content);
        mTvCancel = (TextView) findViewById(R.id.tv_cancel);
        mTvConfirm = (TextView) findViewById(R.id.tv_confirm);
        mTvContent.setText(mContent);
        mTvCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
        mTvConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
                mOnClickListener.clickSure();
            }
        });
    }

    public interface OnClickListener {
        void clickSure();
    }
}
