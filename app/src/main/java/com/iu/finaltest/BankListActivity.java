package com.iu.finaltest;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.iu.finaltest.Adapters.BankAdapters;
import com.iu.finaltest.Util.ConnectServer;
import com.iu.finaltest.datas.Bank;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class BankListActivity extends BaseActivity {

    List<Bank> bankList = new ArrayList<Bank>();
    BankAdapters mAdapter;
    private android.widget.ListView bankListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_list);

        bindValues();
        setupEvents();
        setValues();

    }


    @Override
    public void setValues() {

    }

    @Override
    public void setupEvents() {

        mAdapter = new BankAdapters(mContext, bankList);
        bankListView.setAdapter(mAdapter);

        getBanksFromServer();
    }

    void getBanksFromServer() {

        ConnectServer.getRequestBanks(mContext, new ConnectServer.JsonResponseHandler() {
            @Override
            public void onResponse(JSONObject json) {
                Log.d("은행목록", json.toString());

                try {
                    int code = json.getInt("code");

                    if (code == 200) {
                        JSONObject data = json.getJSONObject("data");
                        JSONArray banks = data.getJSONArray("banks");

                        for (int i = 0; i < banks.length(); i++) {
                            JSONObject bankJson = banks.getJSONObject(i);

                            Bank bankObject = Bank.getBankFromJson(bankJson);
                            bankList.add(bankObject);
                        }

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                mAdapter.notifyDataSetChanged();
                            }
                        });



                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        });

    }

    @Override
    public void bindValues() {
        this.bankListView = (ListView) findViewById(R.id.bankListView);
    }
}
