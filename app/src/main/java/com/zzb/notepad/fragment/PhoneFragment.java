package com.zzb.notepad.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zzb.notepad.R;
import com.zzb.notepad.base.BaseFragment;

/**
 * 作者： 张梓彬
 * 日期： 2017/9/16 0016
 * 时间： 下午 3:38
 * 描述： 电话
 */
public class PhoneFragment extends BaseFragment {

    @Override
    protected View onBoundView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_phone, container, false);
        return view;
    }
}
