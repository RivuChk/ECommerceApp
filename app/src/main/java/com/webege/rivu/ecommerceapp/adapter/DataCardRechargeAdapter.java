package com.webege.rivu.ecommerceapp.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.webege.rivu.ecommerceapp.DTHRechargeSubmit;
import com.webege.rivu.ecommerceapp.DataCardRechargeSubmit;
import com.webege.rivu.ecommerceapp.R;
import com.webege.rivu.ecommerceapp.item.DTHRechargeItem;
import com.webege.rivu.ecommerceapp.item.DataCardRechargeItem;

import java.util.List;

/**
 * Created by Debraj on 5/29/2016.
 */
public class DataCardRechargeAdapter extends BaseAdapter {

    List<DataCardRechargeItem> dataCardRechargeItems;
    Context context;

    public DataCardRechargeAdapter(List<DataCardRechargeItem> dataCardRechargeItems, Context context) {
        this.dataCardRechargeItems = dataCardRechargeItems;
        this.context = context;
    }

    @Override
    public int getCount() {
        return dataCardRechargeItems.size();
    }

    @Override
    public Object getItem(int position) {
        return dataCardRechargeItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view;
        LayoutInflater mInflater = (LayoutInflater) context
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        view = mInflater.inflate(R.layout.item_mobilerechage, null);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DataCardRechargeSubmit.class);
                context.startActivity(intent);
            }
        });

        return view;
    }
}
