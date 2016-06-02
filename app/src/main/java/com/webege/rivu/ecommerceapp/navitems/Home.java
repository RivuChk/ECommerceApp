package com.webege.rivu.ecommerceapp.navitems;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import com.webege.rivu.ecommerceapp.MainActivity;
import com.webege.rivu.ecommerceapp.R;
import com.webege.rivu.ecommerceapp.adapter.MobileRechargeAdapter;
import com.webege.rivu.ecommerceapp.item.MobileRechargeItem;

import java.util.ArrayList;

/**
 * Created by Debraj on 6/2/2016.
 */
public class Home extends Fragment {

    public static Home instance;
    String[] options = { "Mobile Recharge",
            "DTH Recharge",
            "Data Card Recharge",
            "Postpaid Recharge",
            "Landline Bill",
            "Gas Bill",
            "Electricity Bill",
            "Check Balance",
            "Recharge Report",
            "Utility Report",
            "Balance Transfer",
            "Balance Transfer Report",
            "Change Password",
            "Sign Out",
            "Support"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home,null);
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        instance = this;

        GridView gridView = (GridView)getActivity().findViewById(R.id.gridview);
        ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(),R.layout.item_options,R.id.optionText,options);
        gridView.setAdapter(arrayAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(),options[position],Toast.LENGTH_LONG).show();
            }
        });

    }

}
