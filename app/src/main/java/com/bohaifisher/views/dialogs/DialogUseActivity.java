package com.bohaifisher.views.dialogs;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.bohaifisher.base.ActivityCollector;
import com.bohaifisher.base.BaseActivity;
import com.bohaifisher.mytoolpro.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DialogUseActivity extends BaseActivity {

    @BindView(R.id.btn_logout_dialog_use)
    Button btnLogoutDialogUse;
    @BindView(R.id.btn_waiting_dialog_use)
    Button btnWaitingDialogUse;

    private LogoutDialog mLogoutDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_use);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        mLogoutDialog = new LogoutDialog(this, "是否退出当前APP?");
        mLogoutDialog.setOnClickListener(new LogoutDialog.OnClickListener() {
            @Override
            public void clickSure() {
                ActivityCollector.finishAll();
            }
        });
    }

    @OnClick({R.id.btn_logout_dialog_use, R.id.btn_waiting_dialog_use})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_logout_dialog_use:
                mLogoutDialog.show();
                mLogoutDialog.setCanceledOnTouchOutside(false);
                break;
            case R.id.btn_waiting_dialog_use:
                break;
        }
    }
}
