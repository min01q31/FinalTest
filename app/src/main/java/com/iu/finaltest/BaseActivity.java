package com.iu.finaltest;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {

    public Context mContext = this;

    public abstract void bindValues();
    public abstract void setValues();
    public abstract void setupEvents();
}
