package com.webege.rivu.ecommerceapp.navitems;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.webege.rivu.ecommerceapp.R;
import com.webege.rivu.ecommerceapp.item.RechargeReportItem;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

/**
 * Created by Debraj on 5/29/2016.
 */
public class UtilityReport extends Fragment implements OnClickListener {

    public static UtilityReport instance;
    private Toolbar toolbar;
    Typeface font;

    private EditText fromDateEtxt;
    private EditText toDateEtxt;
    private DatePickerDialog fromDatePickerDialog;
    private DatePickerDialog toDatePickerDialog;
    private SimpleDateFormat dateFormatter;

    String from_date;
    String to_date;
    ListView list_rechage_report;
    List<RechargeReportItem> rechargeReportItems;
    TextView heading_recharge_report;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_recharge_report,null);

        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        instance = this;

        toolbar = (Toolbar)getActivity().findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.utility_report);
        toolbar.setTitleTextColor(-1);
        font = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Lato-Regular.ttf");

        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
        findViewsById();
        setDateTimeField();

        heading_recharge_report = (TextView)getActivity().findViewById(R.id.heading_recharge_report);
        heading_recharge_report.setTypeface(font,Typeface.BOLD);

        list_rechage_report = (ListView)getActivity().findViewById(R.id.list_rechage_report);
        rechargeReportItems = new ArrayList<RechargeReportItem>();

        rechargeReportItems.add(new RechargeReportItem("","","","","","","",""));
        list_rechage_report.setAdapter(new DTHRechargeAdapter(rechargeReportItems,getActivity()));

    }

    private void findViewsById() {
        fromDateEtxt = (EditText)getActivity().findViewById(R.id.edittext_start_date);
        fromDateEtxt.setTypeface(font);
        fromDateEtxt.setInputType(InputType.TYPE_NULL);
        fromDateEtxt.requestFocus();

        toDateEtxt = (EditText)getActivity().findViewById(R.id.edittext_end_date);
        toDateEtxt.setTypeface(font);
        toDateEtxt.setInputType(InputType.TYPE_NULL);
        toDateEtxt.requestFocus();
    }

    private void setDateTimeField() {
        fromDateEtxt.setOnClickListener(this);
        toDateEtxt.setOnClickListener(this);

        Calendar newCalendar = Calendar.getInstance();
        fromDatePickerDialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                fromDateEtxt.setText(dateFormatter.format(newDate.getTime()));
                from_date = dateFormatter.format(newDate.getTime());
                Log.d("Date_time_from",from_date);
            }

        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        toDatePickerDialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                toDateEtxt.setText(dateFormatter.format(newDate.getTime()));
                to_date = dateFormatter.format(newDate.getTime());
                Log.d("Date_time_to",to_date);
            }

        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
    }

    @Override
    public void onClick(View view) {

        if(view == fromDateEtxt) {
            fromDatePickerDialog.show();
        } else if(view == toDateEtxt) {
            toDatePickerDialog.show();
        }
    }


    public class DTHRechargeAdapter extends BaseAdapter {

        List<RechargeReportItem> rechargeReportItems;
        Context context;

        public DTHRechargeAdapter(List<RechargeReportItem> rechargeReportItems, Context context) {
            this.rechargeReportItems = rechargeReportItems;
            this.context = context;
        }

        @Override
        public int getCount() {
            return rechargeReportItems.size();
        }

        @Override
        public Object getItem(int position) {
            return rechargeReportItems.get(position);
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
            view = mInflater.inflate(R.layout.item_recharge_report, null);

            TextView txt_customer_mobile_no = (TextView)view.findViewById(R.id.txt_customer_mobile_no);
            txt_customer_mobile_no.setTypeface(font,Typeface.BOLD);
            txt_customer_mobile_no.setText("CUTOMER MOBILE NUMBER "+"="+" ");

            TextView txt_date_time = (TextView)view.findViewById(R.id.txt_date_time);
            txt_date_time.setText("DATE  TIME "+"="+" ");

            TextView txt_operator_name = (TextView)view.findViewById(R.id.txt_operator_name);
            txt_operator_name.setText("OPERATOR NAME "+"="+" ");

            TextView txt_status = (TextView)view.findViewById(R.id.txt_status);
            txt_status.setText("STATUS "+"="+" ");

            TextView txt_amount = (TextView)view.findViewById(R.id.txt_amount);
            txt_amount.setText("AMOUNT "+"="+" ");

            TextView txt_transID = (TextView)view.findViewById(R.id.txt_transID);
            txt_transID.setText("TRANSID "+"="+" ");

            TextView txt_operator_transID = (TextView)view.findViewById(R.id.txt_operator_transID);
            txt_operator_transID.setText("OPERATOR TRANSID "+"="+" ");

            TextView txt_closing_bal = (TextView)view.findViewById(R.id.txt_closing_bal);
            txt_closing_bal.setText("CLOSING BALANCE "+"="+" ");

            return view;
        }
    }
}
