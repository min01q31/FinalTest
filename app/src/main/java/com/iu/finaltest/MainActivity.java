package com.iu.finaltest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends BaseActivity {

    private android.widget.Button bankListBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bindValues();
        setupEvents();
        setValues();

    }


    @Override
    public void setValues() {

    }

    @Override
    public void setupEvents() {
        bankListBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, BankListActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void bindValues() {
        this.bankListBtn = (Button) findViewById(R.id.bankListBtn);
    }
}
