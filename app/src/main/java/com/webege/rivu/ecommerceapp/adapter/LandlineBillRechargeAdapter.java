package com.webege.rivu.ecommerceapp.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.webege.rivu.ecommerceapp.DTHRechargeSubmit;
import com.webege.rivu.ecommerceapp.R;
import com.webege.rivu.ecommerceapp.item.LandllineBillRechargeItem;
import com.webege.rivu.ecommerceapp.item.PostPaidRechargeItem;
import com.webege.rivu.ecommerceapp.navitems.LandlineBillRecharge;

import java.util.List;

/**
 * Created by Debraj on 5/29/2016.
 */
public class LandlineBillRechargeAdapter extends BaseAdapter {

    List<LandllineBillRechargeItem> landllineBillRechargeItems;
    Context context;

    public LandlineBillRechargeAdapter(List<LandllineBillRechargeItem> landllineBillRechargeItems, Context context) {
        this.landllineBillRechargeItems = landllineBillRechargeItems;
        this.context = context;
    }

    @Override
    public int getCount() {
        return landllineBillRechargeItems.size();
    }

    @Override
    public Object getItem(int position) {
        return landllineBillRechargeItems.get(position);
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

       /* view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, LandlineBillRecharge.class);
                context.startActivity(intent);
            }
        });*/

        TextView txt_provider_name = (TextView) view.findViewById(R.id.txt_provider_name);
        txt_provider_name.setText(landllineBillRechargeItems.get(position).getProviderName());

        return view;
    }
}
