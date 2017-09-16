package com.zzb.notepad.base;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import butterknife.Unbinder;

/**
 * 作者： 张梓彬
 * 日期： 2017/9/16 0016
 * 时间： 下午 2:22
 * 描述： 基础页面
 */

public class BaseActivity extends AppCompatActivity {

    protected Unbinder unbinder;
    public static final String NOTE = "note";
    public static final String ACCOUNT = "account";
    public static final String PHONE = "phone";
    public static final String HELP = "help";

    protected void setReplaceFragment(@IdRes int containerViewId, Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(containerViewId, fragment).commit();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        onBoundView(savedInstanceState);

    }

    protected void onBoundView(Bundle savedInstanceState) {
    }





}
