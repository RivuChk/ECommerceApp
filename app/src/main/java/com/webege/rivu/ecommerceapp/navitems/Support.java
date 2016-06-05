package com.webege.rivu.ecommerceapp.navitems;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

import com.webege.rivu.ecommerceapp.R;

/**
 * Created by Debraj on 5/29/2016.
 */
public class Support extends Fragment{

    public static Support instance;
    private Toolbar toolbar;
    private WebView webView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_webview,null);
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        instance = this;

        toolbar = (Toolbar)getActivity().findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.support);
        toolbar.setTitleTextColor(-1);

        webView = (WebView)getActivity().findViewById(R.id.webView_support);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("http://www.rseclickrecharge.com");
        getActivity().finish();

    }

}
