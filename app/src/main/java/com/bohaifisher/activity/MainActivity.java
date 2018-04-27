package com.bohaifisher.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.bohaifisher.base.BaseActivity;
import com.bohaifisher.broadreceiver.BroadcastTestActivity;
import com.bohaifisher.mytoolpro.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @BindView(R.id.btn_broadcast_test)
    Button btnBroadcastTest;
    @BindView(R.id.btn_dialog_test)
    Button btnDialogTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


    }

    @OnClick({R.id.btn_broadcast_test, R.id.btn_dialog_test})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_broadcast_test:
                startActivity(BroadcastTestActivity.class);
                break;
            case R.id.btn_dialog_test:
                break;
        }
    }
}
