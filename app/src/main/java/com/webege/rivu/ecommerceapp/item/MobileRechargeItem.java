package com.webege.rivu.ecommerceapp.item;

/**
 * Created by Debraj on 5/29/2016.
 */
public class MobileRechargeItem {

    private String providerName;
    private String providerImage;

    public MobileRechargeItem(String providerName, String providerImage) {
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
