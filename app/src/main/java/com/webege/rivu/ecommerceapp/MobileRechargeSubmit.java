package com.webege.rivu.ecommerceapp;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MobileRechargeSubmit extends Activity {

    EditText edittext_enter_no;
    EditText edittext_enter_amount;
    EditText edittext_enter_confirm_amount;
    Button btn_recharge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobile_recharge_submit);

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
