package com.zzb.notepad.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.yarolegovich.slidingrootnav.SlideGravity;
import com.yarolegovich.slidingrootnav.SlidingRootNav;
import com.yarolegovich.slidingrootnav.SlidingRootNavBuilder;
import com.zzb.notepad.R;
import com.zzb.notepad.base.BaseActivity;
import com.zzb.notepad.bean.EventBusMessage;
import com.zzb.notepad.fragment.AccountFragment;
import com.zzb.notepad.fragment.HelpFragment;
import com.zzb.notepad.fragment.LeftFragment;
import com.zzb.notepad.fragment.NoteFragment;
import com.zzb.notepad.fragment.PhoneFragment;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {


    @BindView(R.id.toolbar)
    Toolbar toolbar;
    private SlidingRootNav slidingRootNav;
    private LeftFragment fragment;
    private NoteFragment noteFragment;
    private AccountFragment accountFragment;
    private PhoneFragment phoneFragment;
    private HelpFragment helpFragment;

    @Override
    protected void onBoundView(Bundle savedInstanceState) {
        super.onBoundView(savedInstanceState);
        setContentView(R.layout.activity_main);
        unbinder = ButterKnife.bind(this);
        initView(savedInstanceState);
    }


    private void initView(Bundle savedInstanceState) {
        EventBus.getDefault().register(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setTitle(getResources().getString(R.string.note));
        toolbar.setNavigationIcon(R.drawable.ic_add);
        fragment = new LeftFragment();
        noteFragment = new NoteFragment();
        accountFragment = new AccountFragment();
        phoneFragment = new PhoneFragment();
        helpFragment = new HelpFragment();
        slidingRootNav = new SlidingRootNavBuilder(this)
                .withToolbarMenuToggle(toolbar)
                .withSavedState(savedInstanceState)
                .withMenuLayout(R.layout.left_layout)
                .withMenuOpened(false)
                .withMenuLocked(false)
                .withGravity(SlideGravity.LEFT)
                .withSavedState(savedInstanceState)
                .withContentClickableWhenMenuOpened(true)
                .inject();
        setReplaceFragment(R.id.lay_fram_left, fragment);
        setReplaceFragment(R.id.lay_fram, noteFragment);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.titleicon, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.icon_add:
                Toast.makeText(this, "添加", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
        unbinder.unbind();
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void getMessage(EventBusMessage event) {
        switch (event.getMsg()) {
            case NOTE:
                setReplaceFragment(R.id.lay_fram, noteFragment);
                slidingRootNav.closeMenu();
                toolbar.setTitle(getResources().getString(R.string.note));

                break;
            case ACCOUNT:
                setReplaceFragment(R.id.lay_fram, accountFragment);
                slidingRootNav.closeMenu();
                toolbar.setTitle(getResources().getString(R.string.account));

                break;
            case PHONE:
                setReplaceFragment(R.id.lay_fram, phoneFragment);
                slidingRootNav.closeMenu();
                toolbar.setTitle(getResources().getString(R.string.phone));

                break;
            case HELP:
                setReplaceFragment(R.id.lay_fram, helpFragment);
                slidingRootNav.closeMenu();
                toolbar.setTitle(getResources().getString(R.string.help));

                break;
        }
    }
}
