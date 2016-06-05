package com.webege.rivu.ecommerceapp;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View.OnClickListener;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.os.Bundle;
import android.text.InputType;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.DatePicker;


public class GasBillRechargeSubmit extends Activity implements OnClickListener {

    TextView txt_bill_payment;
    EditText edittext_customar_name;
    EditText edittext_customar_number;
    EditText edittext_amount;
    EditText edittext_mobile_number;
    EditText edittext_due_date;
    Button btn_transact;
    private Toolbar toolbar;


    private EditText fromDateEtxt;
 //   private EditText toDateEtxt;

    private DatePickerDialog fromDatePickerDialog;
    private DatePickerDialog toDatePickerDialog;

    private SimpleDateFormat dateFormatter;

    String date_time="";
    Typeface font;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill_payment_submit);

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

        font = Typeface.createFromAsset(getAssets(), "fonts/Lato-Regular.ttf");

        txt_bill_payment = (TextView)findViewById(R.id.txt_bill_payment);
        txt_bill_payment.setTypeface(font,Typeface.BOLD);


        edittext_customar_name = (EditText)findViewById(R.id.edittext_customar_name);
        edittext_customar_name.setTypeface(font);

        edittext_customar_number = (EditText)findViewById(R.id.edittext_customar_number);
        edittext_customar_number.setTypeface(font);

        edittext_amount = (EditText)findViewById(R.id.edittext_amount);
        edittext_amount.setTypeface(font);

        edittext_mobile_number = (EditText)findViewById(R.id.edittext_mobile_number);
        edittext_mobile_number.setTypeface(font);

        /*edittext_due_date = (EditText)findViewById(R.id.edittext_due_date);
        edittext_due_date.setTypeface(font);*/

        btn_transact = (Button)findViewById(R.id.btn_transact);
        btn_transact.setTypeface(font);

        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);

        findViewsById();

        setDateTimeField();

        Log.d("Date_time_2",date_time);


    }

    private void findViewsById() {
        fromDateEtxt = (EditText) findViewById(R.id.edittext_due_date);
        fromDateEtxt.setTypeface(font);
        fromDateEtxt.setInputType(InputType.TYPE_NULL);
        fromDateEtxt.requestFocus();

       /* toDateEtxt = (EditText) findViewById(R.id.etxt_todate);
        toDateEtxt.setInputType(InputType.TYPE_NULL);*/
    }

    private void setDateTimeField() {
        fromDateEtxt.setOnClickListener(this);
    //    toDateEtxt.setOnClickListener(this);

        Calendar newCalendar = Calendar.getInstance();
        fromDatePickerDialog = new DatePickerDialog(this, new OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                fromDateEtxt.setText(dateFormatter.format(newDate.getTime()));
                date_time = dateFormatter.format(newDate.getTime());
                Log.d("Date_time_1",date_time);
            }

        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        /*toDatePickerDialog = new DatePickerDialog(this, new OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                toDateEtxt.setText(dateFormatter.format(newDate.getTime()));
            }

        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));*/
    }



    @Override
    public void onClick(View view) {

        if(view == fromDateEtxt) {
            fromDatePickerDialog.show();
        } /*else if(view == toDateEtxt) {
            toDatePickerDialog.show();
        }*/
    }
}
