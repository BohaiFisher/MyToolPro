package com.bohaifisher.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.bohaifisher.mytoolpro.R;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
    }

    /**
     * 跳转Activity带Bundle
     *
     * @param clzz
     * @param bundle
     */
    protected void startActivity(Class<?> clzz, Bundle bundle) {
        Intent intent = new Intent();
        intent.setClass(this, clzz);
        if (bundle != null) {
            intent.putExtras(bundle);
        }

        startActivity(intent);
    }


    /**
     * 跳转Activity不带Bundle
     *
     * @param clzz
     */
    protected void startActivity(Class<?> clzz) {
        startActivity(clzz, null);
    }

    /**
     * ActivityForResult带有Bundle
     *
     * @param clzz
     * @param bundle
     * @param requestCode
     */
    protected void startActivityForResult(Class<?> clzz, Bundle bundle, int requestCode) {
        Intent intent = new Intent();
        intent.setClass(this, clzz);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivityForResult(intent, requestCode);
    }

    /**
     * ActivityForResult不带Bundle
     *
     * @param clzz
     * @param requestCode
     */
    protected void startActivityForResult(Class<?> clzz, int requestCode) {
        startActivityForResult(clzz, null, requestCode);
    }

    /**
     * 在BaseActivity中重写了一些显示Toast，Dialog的操作，
     * 这样我们在Activity中显示这些UI的时候可以统一调用方法与UI风格。
     *
     * @param toast 内容
     */
    protected void showToastLong(String toast) {
        if (toast != null && !toast.trim().equals("")) {
            Toast.makeText(getApplicationContext(), toast, Toast.LENGTH_LONG).show();
        }
    }

    /**
     * 在BaseActivity中重写了一些显示Toast，Dialog的操作，
     * 这样我们在Activity中显示这些UI的时候可以统一调用方法与UI风格。
     *
     * @param toast 内容
     */
    protected void showToastShort(String toast) {
        if (toast != null && !toast.trim().equals("")) {
            Toast.makeText(getApplicationContext(), toast, Toast.LENGTH_SHORT).show();
        }
    }

}
