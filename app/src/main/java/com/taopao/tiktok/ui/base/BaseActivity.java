package com.taopao.tiktok.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.taopao.tiktok.ui.mvp.IPresenter;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @Author：淘跑
 * @Date: 2018/9/2 16:40
 * @Use： Activity基类
 */
public class BaseActivity<P extends IPresenter> extends AppCompatActivity implements IActivity {
    private Unbinder mUnbinder;
    @Inject
    private P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int viewResID = layoutResID();
        if (viewResID != 0) {
            setContentView(viewResID);
            //绑定到butterknife
            mUnbinder = ButterKnife.bind(this);
        } else {
            //没有设置界面 不setContentView()
        }
        initView(savedInstanceState);
        initData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mUnbinder != null && mUnbinder != Unbinder.EMPTY) {
            //解绑ButterKnife
            mUnbinder.unbind();
            mUnbinder = null;
        }
    }

    @Override
    public int layoutResID() {
        return 0;
    }

    @Override
    public void initView(@Nullable Bundle savedInstanceState) {

    }

    @Override
    public void initData() {

    }
}
