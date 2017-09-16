package com.zzb.notepad.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.Unbinder;

/**
 * 作者： 张梓彬
 * 日期： 2017/9/16 0016
 * 时间： 下午 2:31
 * 描述： 基础Fragment封装
 */

public class BaseFragment extends Fragment {
    protected View view;
    protected Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return onBoundView(inflater, container, savedInstanceState);
    }

    protected View onBoundView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }


}
