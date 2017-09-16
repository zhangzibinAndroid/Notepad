package com.zzb.notepad.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zzb.notepad.R;
import com.zzb.notepad.base.BaseActivity;
import com.zzb.notepad.base.BaseFragment;
import com.zzb.notepad.bean.EventBusMessage;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 作者： 张梓彬
 * 日期： 2017/9/16 0016
 * 时间： 上午 10:31
 * 描述： 左侧侧滑页面
 */
public class LeftFragment extends BaseFragment {


    private static final String TAG = "LeftFragment";
    @BindViews({R.id.tv_home_page, R.id.tv_account, R.id.tv_phone, R.id.tv_help})
    TextView[] tv_select;


    @Override
    protected View onBoundView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_left, container, false);
        unbinder = ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {
        tv_select[0].setSelected(true);

    }


    @OnClick({R.id.tv_home_page, R.id.tv_account, R.id.tv_phone, R.id.tv_help})
    public void onViewClicked(View view) {
        for (int i = 0; i < tv_select.length; i++) {
            tv_select[i].setSelected(false);
        }
        switch (view.getId()) {
            case R.id.tv_home_page:
                tv_select[0].setSelected(true);
                EventBus.getDefault().post(new EventBusMessage(BaseActivity.NOTE));
                break;
            case R.id.tv_account:
                tv_select[1].setSelected(true);
                EventBus.getDefault().post(new EventBusMessage(BaseActivity.ACCOUNT));

                break;
            case R.id.tv_phone:
                tv_select[2].setSelected(true);
                EventBus.getDefault().post(new EventBusMessage(BaseActivity.PHONE));

                break;
            case R.id.tv_help:
                tv_select[3].setSelected(true);
                EventBus.getDefault().post(new EventBusMessage(BaseActivity.HELP));

                break;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
