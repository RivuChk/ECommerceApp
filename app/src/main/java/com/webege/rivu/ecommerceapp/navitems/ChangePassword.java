package com.webege.rivu.ecommerceapp.navitems;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.webege.rivu.ecommerceapp.R;

/**
 * Created by Debraj on 5/29/2016.
 */
public class ChangePassword extends Fragment{

    public static ChangePassword instance;
    private Toolbar toolbar;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_change_password,null);
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        instance = this;

        toolbar = (Toolbar)getActivity().findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.change_password);
        toolbar.setTitleTextColor(-1);
        Typeface font = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Lato-Regular.ttf");

        EditText edittext_new_passwd = (EditText)getActivity().findViewById(R.id.edittext_new_passwd);
        edittext_new_passwd.setTypeface(font);

        Button btn_chng_passwd = (Button) getActivity().findViewById(R.id.btn_chng_passwd);
        btn_chng_passwd.setTypeface(font);

    }

}
