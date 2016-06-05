package com.webege.rivu.ecommerceapp;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.TypefaceSpan;
import android.view.SubMenu;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

import com.webege.rivu.ecommerceapp.navitems.BalanceTransfer;
import com.webege.rivu.ecommerceapp.navitems.BalanceTransferReport;
import com.webege.rivu.ecommerceapp.navitems.ChangePassword;
import com.webege.rivu.ecommerceapp.navitems.CheckBalance;
import com.webege.rivu.ecommerceapp.navitems.DTHRecharge;
import com.webege.rivu.ecommerceapp.navitems.DataCardRecharge;
import com.webege.rivu.ecommerceapp.navitems.ElectricityBillRecharge;
import com.webege.rivu.ecommerceapp.navitems.GasBillRecharge;
import com.webege.rivu.ecommerceapp.navitems.Home;
import com.webege.rivu.ecommerceapp.navitems.LandlineBillRecharge;
import com.webege.rivu.ecommerceapp.navitems.MobileRecharge;
import com.webege.rivu.ecommerceapp.navitems.PostPaidRecharge;
import com.webege.rivu.ecommerceapp.navitems.RechargeReport;
import com.webege.rivu.ecommerceapp.navitems.Support;
import com.webege.rivu.ecommerceapp.navitems.UtilityReport;
import com.webege.rivu.ecommerceapp.utility.CustomTypefaceSpan;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       /* if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getColor(R.color.colorPrimaryDark));
        }*/

        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Menu m = navigationView.getMenu();
        for (int i=0;i<m.size();i++) {
            MenuItem mi = m.getItem(i);

            //for aapplying a font to subMenu ...
            SubMenu subMenu = mi.getSubMenu();
            if (subMenu!=null && subMenu.size() >0 ) {
                for (int j=0; j <subMenu.size();j++) {
                    MenuItem subMenuItem = subMenu.getItem(j);
                    applyFontToMenuItem(subMenuItem);
                }
            }

            //the method we have create in activity
            applyFontToMenuItem(mi);
        }


        Home fragment = new Home();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.content, fragment);
        ft.commit();

    }

    private void applyFontToMenuItem(MenuItem mi) {
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/Lato-Regular.ttf");
        SpannableString mNewTitle = new SpannableString(mi.getTitle());
        mNewTitle.setSpan(new CustomTypefaceSpan("" , font), 0 , mNewTitle.length(),  Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        mi.setTitle(mNewTitle);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Fragment fragment = null;

        if(id == R.id.nav_home){

            fragment = new Home();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content, fragment);
            ft.commit();

        }else if(id == R.id.nav_mrecharge){

            fragment = new MobileRecharge();
            FragmentTransaction ft_mobile = getSupportFragmentManager().beginTransaction();
            ft_mobile.replace(R.id.content, fragment);
            ft_mobile.commit();

        }else if(id == R.id.nav_dthrecharge){

            fragment = new DTHRecharge();
            FragmentTransaction ft_dth = getSupportFragmentManager().beginTransaction();
            ft_dth.replace(R.id.content, fragment);
            ft_dth.commit();

        }else if(id == R.id.nav_datacard_recharge){

            fragment = new DataCardRecharge();
            FragmentTransaction ft_datacard = getSupportFragmentManager().beginTransaction();
            ft_datacard.replace(R.id.content, fragment);
            ft_datacard.commit();

        }else if(id == R.id.nav_postpaid_recharge){

            fragment = new PostPaidRecharge();
            FragmentTransaction ft_postpaid = getSupportFragmentManager().beginTransaction();
            ft_postpaid.replace(R.id.content, fragment);
            ft_postpaid.commit();

        }else if(id == R.id.nav_landline_bill){

            fragment = new LandlineBillRecharge();
            FragmentTransaction ft_landline_bill = getSupportFragmentManager().beginTransaction();
            ft_landline_bill.replace(R.id.content, fragment);
            ft_landline_bill.commit();

        }else if(id == R.id.nav_gasbill){

            fragment = new GasBillRecharge();
            FragmentTransaction ft_gas_bill = getSupportFragmentManager().beginTransaction();
            ft_gas_bill.replace(R.id.content, fragment);
            ft_gas_bill.commit();

        }else if(id == R.id.nav_electricitybill){

            fragment = new ElectricityBillRecharge();
            FragmentTransaction ft_electricity_bill = getSupportFragmentManager().beginTransaction();
            ft_electricity_bill.replace(R.id.content, fragment);
            ft_electricity_bill.commit();

        }else if(id == R.id.nav_check_bal){

            fragment = new CheckBalance();
            FragmentTransaction ft_check_bal = getSupportFragmentManager().beginTransaction();
            ft_check_bal.replace(R.id.content, fragment);
            ft_check_bal.commit();

        }else if(id == R.id.nav_recharge_report){

            fragment = new RechargeReport();
            FragmentTransaction ft_recharge_rpt = getSupportFragmentManager().beginTransaction();
            ft_recharge_rpt.replace(R.id.content, fragment);
            ft_recharge_rpt.commit();
        }else if(id == R.id.nav_utility_report){

            fragment = new UtilityReport();
            FragmentTransaction ft_utility_rpt = getSupportFragmentManager().beginTransaction();
            ft_utility_rpt.replace(R.id.content, fragment);
            ft_utility_rpt.commit();
        } else if(id == R.id.nav_balance_transfer){

            fragment = new BalanceTransfer();
            FragmentTransaction ft_balance_transfr = getSupportFragmentManager().beginTransaction();
            ft_balance_transfr.replace(R.id.content, fragment);
            ft_balance_transfr.commit();

        } else if(id == R.id.nav_bal_transfer_rept){

            fragment = new BalanceTransferReport();
            FragmentTransaction ft_balance_transfr_rpt = getSupportFragmentManager().beginTransaction();
            ft_balance_transfr_rpt.replace(R.id.content, fragment);
            ft_balance_transfr_rpt.commit();

        }else if(id == R.id.nav_change_pass){

            fragment = new ChangePassword();
            FragmentTransaction ft_chng_passwd = getSupportFragmentManager().beginTransaction();
            ft_chng_passwd.replace(R.id.content, fragment);
            ft_chng_passwd.commit();

        }else if(id == R.id.nav_support){

            fragment = new Support();
            FragmentTransaction ft_support = getSupportFragmentManager().beginTransaction();
            ft_support.replace(R.id.content, fragment);
            ft_support.commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
