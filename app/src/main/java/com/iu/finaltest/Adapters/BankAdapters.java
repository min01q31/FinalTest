package com.iu.finaltest.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.iu.finaltest.R;
import com.iu.finaltest.datas.Bank;

import java.util.List;

public class BankAdapters extends ArrayAdapter<Bank> {

    Context mContext;
    List<Bank> mList;
    LayoutInflater inf;

    public BankAdapters(Context context, List<Bank> list){
        super (context, R.layout.bank_list_item,list);

        mContext = context;
        mList = list;
        inf = LayoutInflater.from(mContext);
    }


    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {
        View row = convertView;

        if(row == null){
            row = inf.inflate(R.layout.bank_list_item, null);
        }

        ImageView logoImgView = row.findViewById(R.id.logoImgView);
        TextView bankNameTxt = row.findViewById(R.id.bankNameTxt);
        TextView bankCodeTxt = row.findViewById(R.id.bankCodeTxt);

        Bank data =mList.get(position);

        Glide.with(mContext).load(data.getLogoUrl()).into(logoImgView);
        bankNameTxt.setText(data.getName());

        String codeFormat = String.format("(%s)",data.getCode());
        bankCodeTxt.setText(codeFormat);

        return row;
    }
}
