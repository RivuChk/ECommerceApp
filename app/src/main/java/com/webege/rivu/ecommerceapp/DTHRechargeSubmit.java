package com.webege.rivu.ecommerceapp;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DTHRechargeSubmit extends Activity {

    EditText edittext_enter_no;
    EditText edittext_enter_amount;
    EditText edittext_enter_confirm_amount;
    Button btn_recharge;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobile_recharge_submit);

        toolbar = (Toolbar)findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.mobile_recharge_submit_details);
        toolbar.setTitleTextColor(-1);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/Lato-Regular.ttf");

        edittext_enter_no = (EditText)findViewById(R.id.edittext_enter_no);
        edittext_enter_no.setTypeface(font);

        edittext_enter_amount = (EditText)findViewById(R.id.edittext_enter_amount);
        edittext_enter_amount.setTypeface(font);

        edittext_enter_confirm_amount = (EditText)findViewById(R.id.edittext_enter_confirm_amount);
        edittext_enter_confirm_amount.setTypeface(font);

        btn_recharge = (Button)findViewById(R.id.btn_recharge);
        btn_recharge.setTypeface(font);

    }
}
