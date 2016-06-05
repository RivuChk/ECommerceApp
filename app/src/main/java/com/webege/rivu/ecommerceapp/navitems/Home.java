package com.webege.rivu.ecommerceapp.navitems;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
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
               // Toast.makeText(getActivity(),options[position],Toast.LENGTH_LONG).show();

                Fragment fragment = null;
                if(options[position].equals("Mobile Recharge")){

                    fragment = new MobileRecharge();
                    FragmentTransaction ft_mobile = getActivity().getSupportFragmentManager().beginTransaction();
                    ft_mobile.replace(R.id.content, fragment);
                    ft_mobile.commit();

                }else if(options[position].equals("DTH Recharge")){

                    fragment = new DTHRecharge();
                    FragmentTransaction ft_dth = getActivity().getSupportFragmentManager().beginTransaction();
                    ft_dth.replace(R.id.content, fragment);
                    ft_dth.commit();

                }else if(options[position].equals("Data Card Recharge")){

                    fragment = new DataCardRecharge();
                    FragmentTransaction ft_datacard = getActivity().getSupportFragmentManager().beginTransaction();
                    ft_datacard.replace(R.id.content, fragment);
                    ft_datacard.commit();

                }else if(options[position].equals("Postpaid Recharge")){

                    fragment = new PostPaidRecharge();
                    FragmentTransaction ft_postpaid = getActivity().getSupportFragmentManager().beginTransaction();
                    ft_postpaid.replace(R.id.content, fragment);
                    ft_postpaid.commit();

                }else if(options[position].equals("Landline Bill")){

                    fragment = new LandlineBillRecharge();
                    FragmentTransaction ft_landline_bill = getActivity().getSupportFragmentManager().beginTransaction();
                    ft_landline_bill.replace(R.id.content, fragment);
                    ft_landline_bill.commit();

                }else if(options[position].equals("Gas Bill")){

                    fragment = new GasBillRecharge();
                    FragmentTransaction ft_gas_bill = getActivity().getSupportFragmentManager().beginTransaction();
                    ft_gas_bill.replace(R.id.content, fragment);
                    ft_gas_bill.commit();

                }else if(options[position].equals("Electricity Bill")){

                    fragment = new ElectricityBillRecharge();
                    FragmentTransaction ft_electricity_bill = getActivity().getSupportFragmentManager().beginTransaction();
                    ft_electricity_bill.replace(R.id.content, fragment);
                    ft_electricity_bill.commit();

                }else if(options[position].equals("Check Balance")){

                    fragment = new CheckBalance();
                    FragmentTransaction ft_check_bal = getActivity().getSupportFragmentManager().beginTransaction();
                    ft_check_bal.replace(R.id.content, fragment);
                    ft_check_bal.commit();

                }else if(options[position].equals("Recharge Report")){

                    fragment = new RechargeReport();
                    FragmentTransaction ft_recharge_rpt = getActivity().getSupportFragmentManager().beginTransaction();
                    ft_recharge_rpt.replace(R.id.content, fragment);
                    ft_recharge_rpt.commit();
                }else if(options[position].equals("Utility Report")){

                    fragment = new UtilityReport();
                    FragmentTransaction ft_utility_rpt = getActivity().getSupportFragmentManager().beginTransaction();
                    ft_utility_rpt.replace(R.id.content, fragment);
                    ft_utility_rpt.commit();
                } else if(options[position].equals("Balance Transfer")){

                    fragment = new BalanceTransfer();
                    FragmentTransaction ft_balance_transfr = getActivity().getSupportFragmentManager().beginTransaction();
                    ft_balance_transfr.replace(R.id.content, fragment);
                    ft_balance_transfr.commit();

                } else if(options[position].equals("Balance Transfer Report")){

                    fragment = new BalanceTransferReport();
                    FragmentTransaction ft_balance_transfr_rpt = getActivity().getSupportFragmentManager().beginTransaction();
                    ft_balance_transfr_rpt.replace(R.id.content, fragment);
                    ft_balance_transfr_rpt.commit();

                }else if(options[position].equals("Change Password")){

                    fragment = new ChangePassword();
                    FragmentTransaction ft_chng_passwd = getActivity().getSupportFragmentManager().beginTransaction();
                    ft_chng_passwd.replace(R.id.content, fragment);
                    ft_chng_passwd.commit();

                }else if(options[position].equals("Sign Out")){

                    /*fragment = new Support();
                    FragmentTransaction ft_support = getActivity().getSupportFragmentManager().beginTransaction();
                    ft_support.replace(R.id.content, fragment);
                    ft_support.commit();*/

                }else if(options[position].equals("Support")){

                    fragment = new Support();
                    FragmentTransaction ft_support = getActivity().getSupportFragmentManager().beginTransaction();
                    ft_support.replace(R.id.content, fragment);
                    ft_support.commit();
                }

            }
        });

    }



}
