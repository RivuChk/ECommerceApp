package com.webege.rivu.ecommerceapp.navitems;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.webege.rivu.ecommerceapp.R;
import com.webege.rivu.ecommerceapp.adapter.MobileRechargeAdapter;
import com.webege.rivu.ecommerceapp.item.MobileRechargeItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Debraj on 5/29/2016.
 */
public class MobileRecharge extends AppCompatActivity{

     List<MobileRechargeItem> mobileRechargeItems;
     MobileRechargeAdapter mobileRechargeAdapter;
     ListView list_mobile_recharge;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobile_rechage);

        list_mobile_recharge = (ListView)findViewById(R.id.list_mobile_recharge);
        mobileRechargeItems = new ArrayList<MobileRechargeItem>();

        mobileRechargeItems.add(new MobileRechargeItem("","Aircel"));
        mobileRechargeAdapter = new MobileRechargeAdapter(mobileRechargeItems,MobileRecharge.this);
        list_mobile_recharge.setAdapter(mobileRechargeAdapter);

    }
}
