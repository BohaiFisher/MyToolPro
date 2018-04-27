package com.bohaifisher.broadreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.bohaifisher.base.BaseActivity;
import com.bohaifisher.mytoolpro.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 关于两种方式的“广播”实现
 */
public class BroadcastTestActivity extends BaseActivity {

    @BindView(R.id.btn_inner_broad_test)
    Button btnInnerBroadTest;
    @BindView(R.id.btn_outer_broad_test)
    Button btnOuterBroadTest;
    private InnerBroadReceiver mInnerBroadReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast_test);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.bohaifisher.broadreceiver.InnerBroadReceiver");
        mInnerBroadReceiver = new InnerBroadReceiver();
        registerReceiver(mInnerBroadReceiver, intentFilter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(mInnerBroadReceiver);
    }

    @OnClick({R.id.btn_inner_broad_test, R.id.btn_outer_broad_test})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_inner_broad_test:
                Intent innerIntent = new Intent();
                innerIntent.setAction("com.bohaifisher.broadreceiver.InnerBroadReceiver");
                sendBroadcast(innerIntent);
                break;
            case R.id.btn_outer_broad_test:
                Intent outerIntent = new Intent();
                outerIntent.setAction("com.bohaifisher.broadreceiver.OuterBroadReceiver");
                sendBroadcast(outerIntent);
                break;
        }
    }

    class InnerBroadReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            showToastShort("This is an inner broadcast receiver.");
        }
    }
}
