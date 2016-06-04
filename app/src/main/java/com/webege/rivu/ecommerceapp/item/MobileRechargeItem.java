package com.webege.rivu.ecommerceapp.item;

/**
 * Created by Debraj on 5/29/2016.
 */
public class MobileRechargeItem {

    private String providerName;
    private String providerCode;

    public MobileRechargeItem(String providerName, String providerCode) {
        this.providerName = providerName;
        this.providerCode = providerCode;
    }

    public String getProviderName() {
        return providerName;
    }

    public String getProviderCode() {
        return providerCode;
    }
}
