package com.webege.rivu.ecommerceapp.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.webege.rivu.ecommerceapp.MobileRechargeSubmit;
import com.webege.rivu.ecommerceapp.R;
import com.webege.rivu.ecommerceapp.item.MobileRechargeItem;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Debraj on 5/29/2016.
 */
public class MobileRechargeAdapter extends BaseAdapter {

    List<MobileRechargeItem> mobileRechargeItems = new ArrayList<>();
    Context context;

    public MobileRechargeAdapter(Collection<MobileRechargeItem> mobileRechargeItems, Context context) {
        this.mobileRechargeItems.clear();
        this.mobileRechargeItems.addAll(mobileRechargeItems);
        this.context = context;
    }

    @Override
    public int getCount() {
        return mobileRechargeItems.size();
    }

    @Override
    public Object getItem(int position) {
        return mobileRechargeItems.get(position);
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

        TextView txt_store_name = (TextView) view.findViewById(R.id.txt_store_name);
        txt_store_name.setText(mobileRechargeItems.get(position).getProviderName());

//        view.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(context, MobileRechargeSubmit.class);
//                context.startActivity(intent);
//            }
//        });

        return view;
    }
}
