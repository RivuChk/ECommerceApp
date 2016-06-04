package com.webege.rivu.ecommerceapp.navitems;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.webege.rivu.ecommerceapp.R;
import com.webege.rivu.ecommerceapp.adapter.DataCardRechargeAdapter;
import com.webege.rivu.ecommerceapp.adapter.PostPaidRechargeAdapter;
import com.webege.rivu.ecommerceapp.item.DataCardRechargeItem;
import com.webege.rivu.ecommerceapp.item.PostPaidRechargeItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Debraj on 5/29/2016.
 */
public class PostPaidRecharge extends Fragment{

    List<PostPaidRechargeItem> postPaidRechargeItems;
    PostPaidRechargeAdapter postPaidRechargeAdapter;
    ListView list_mobile_recharge;
    public static PostPaidRecharge instance;
    private Toolbar toolbar;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Log.d("oncreate","2");

        View rootView = inflater.inflate(R.layout.activity_mobile_rechage,null);

        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        instance = this;

        toolbar = (Toolbar)getActivity().findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.post_paid_recharge);
        toolbar.setTitleTextColor(-1);
        /*toolbar.setNavigationIcon(R.drawable.ic_arrow_back);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });*/

        list_mobile_recharge = (ListView)getActivity().findViewById(R.id.list_mobile_recharge);
        postPaidRechargeItems = new ArrayList<PostPaidRechargeItem>();

        postPaidRechargeItems.add(new PostPaidRechargeItem("","Aircel"));
        postPaidRechargeAdapter = new PostPaidRechargeAdapter(postPaidRechargeItems,getActivity());
        list_mobile_recharge.setAdapter(postPaidRechargeAdapter);

    }

}