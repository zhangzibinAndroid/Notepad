package com.zzb.notepad.application;
import android.app.Application;
import com.zhy.autolayout.config.AutoLayoutConifg;

/**
 * 作者： 张梓彬
 * 日期： 2017/9/16 0016
 * 时间： 上午 10:31
 * 描述： Application配置
 */

public class NotepadApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        AutoLayoutConifg.getInstance().useDeviceSize();
    }
}
