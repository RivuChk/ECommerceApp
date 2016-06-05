package com.webege.rivu.ecommerceapp.navitems;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.webege.rivu.ecommerceapp.DTHRechargeSubmit;
import com.webege.rivu.ecommerceapp.R;
import com.webege.rivu.ecommerceapp.adapter.DTHRechargeAdapter;
import com.webege.rivu.ecommerceapp.adapter.ElectricityBillRechargeAdapter;
import com.webege.rivu.ecommerceapp.adapter.GasBillRechargeAdapter;
import com.webege.rivu.ecommerceapp.item.DTHRechargeItem;
import com.webege.rivu.ecommerceapp.item.ElectricityBillRechargeItem;
import com.webege.rivu.ecommerceapp.item.GasBillRechargeItem;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

/**
 * Created by Debraj on 5/29/2016.
 */
public class ElectricityBillRecharge extends Fragment{

    List<ElectricityBillRechargeItem> electricityBillRechargeItems;
    ElectricityBillRechargeAdapter electricityBillRechargeAdapter;
    ListView list_elec_bill_recharge;
    public static ElectricityBillRecharge instance;
    private Toolbar toolbar;
    HashMap<String,String> operators=new HashMap<>();



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_mobile_rechage,null);
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        instance = this;

        toolbar = (Toolbar)getActivity().findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.electricity_bill);
        toolbar.setTitleTextColor(-1);

        list_elec_bill_recharge = (ListView)getActivity().findViewById(R.id.list_mobile_recharge);
        electricityBillRechargeItems = new ArrayList<ElectricityBillRechargeItem>();


        list_elec_bill_recharge.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), DTHRechargeSubmit.class);
                startActivity(intent);
            }
        });

        getOperators();

    }


    private void getOperators(){
        RequestQueue queue = Volley.newRequestQueue(getActivity());
        String url ="http://www.mazicmoney.in/GetAllOperator?Type=7";

        //Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("Response",response);


                        Document doc = null;
                        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                        try {

                            DocumentBuilder db = dbf.newDocumentBuilder();

                            InputSource is = new InputSource();
                            is.setCharacterStream(new StringReader(response));
                            doc = db.parse(is);

                        } catch (ParserConfigurationException e) {
                            Log.e("Error: ", e.getMessage());
                        } catch (SAXException e) {
                            Log.e("Error: ", e.getMessage());
                        } catch (IOException e) {
                            Log.e("Error: ", e.getMessage());
                        }

                        NodeList nodeList = doc.getElementsByTagName("ITEM");

                        for (int i = 0; i < nodeList.getLength(); i++) {
                            Element e = (Element) nodeList.item(i);
                            String name = getValue(e, "SERVICEPROVIDER"); // name child value
                            String code = getValue(e, "OPERATORCODE"); // code child value
                            operators.put(name,code);
                            electricityBillRechargeItems.add(new ElectricityBillRechargeItem(name,code));
                        }

                        electricityBillRechargeAdapter = new ElectricityBillRechargeAdapter(electricityBillRechargeItems,getActivity());
                        list_elec_bill_recharge.setAdapter(electricityBillRechargeAdapter);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Error",error.toString(),error);
            }
        });
// Add the request to the RequestQueue.
        queue.add(stringRequest);
    }

    public String getValue(Element item, String str) {
        NodeList n = item.getElementsByTagName(str);
        return this.getElementValue(n.item(0));
    }

    public final String getElementValue( Node elem ) {
        Node child;
        if( elem != null){
            if (elem.hasChildNodes()){
                for( child = elem.getFirstChild(); child != null; child = child.getNextSibling() ){
                    if( child.getNodeType() == Node.TEXT_NODE  ){
                        return child.getNodeValue();
                    }
                }
            }
        }
        return "";
    }



}
