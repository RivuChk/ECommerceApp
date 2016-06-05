package com.webege.rivu.ecommerceapp.navitems;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.webege.rivu.ecommerceapp.R;
import com.webege.rivu.ecommerceapp.adapter.DTHRechargeAdapter;
import com.webege.rivu.ecommerceapp.item.DTHRechargeItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Debraj on 5/29/2016.
 */
public class BalanceTransfer extends Fragment{

    public static BalanceTransfer instance;
    private Toolbar toolbar;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_balance_transfer,null);
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        instance = this;

        toolbar = (Toolbar)getActivity().findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.balance_transfer);
        toolbar.setTitleTextColor(-1);
        Typeface font = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Lato-Regular.ttf");

        EditText edittext_number = (EditText)getActivity().findViewById(R.id.edittext_number);
        edittext_number.setTypeface(font);

        EditText edittext_amount = (EditText)getActivity().findViewById(R.id.edittext_amount);
        edittext_amount.setTypeface(font);

        Button btn_transfer = (Button) getActivity().findViewById(R.id.btn_transfer);
        btn_transfer.setTypeface(font);

    }

}
