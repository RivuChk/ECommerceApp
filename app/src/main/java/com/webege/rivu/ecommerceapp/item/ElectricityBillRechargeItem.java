package com.webege.rivu.ecommerceapp.item;

/**
 * Created by Debraj on 6/4/2016.
 */
public class ElectricityBillRechargeItem {

    private String providerName;
    private String providerImage;

    public ElectricityBillRechargeItem(String providerName, String providerImage) {
        this.providerName = providerName;
        this.providerImage = providerImage;
    }

    public String getProviderName() {
        return providerName;
    }

    public String getProviderImage() {
        return providerImage;
    }
}
