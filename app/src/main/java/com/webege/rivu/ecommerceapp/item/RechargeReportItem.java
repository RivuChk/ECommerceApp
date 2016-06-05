package com.webege.rivu.ecommerceapp.item;

/**
 * Created by Debraj on 6/5/2016.
 */
public class RechargeReportItem {

    String customerMobileNo;
    String dateTime;
    String operatorName;
    String status;
    String amount;
    String transID;
    String operatorTransID;
    String closingBal;

    public RechargeReportItem(String customerMobileNo, String dateTime, String operatorName, String status, String amount, String transID, String operatorTransID, String closingBal) {
        this.customerMobileNo = customerMobileNo;
        this.dateTime = dateTime;
        this.operatorName = operatorName;
        this.status = status;
        this.amount = amount;
        this.transID = transID;
        this.operatorTransID = operatorTransID;
        this.closingBal = closingBal;
    }

    public String getCustomerMobileNo() {
        return customerMobileNo;
    }

    public String getDateTime() {
        return dateTime;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public String getStatus() {
        return status;
    }

    public String getAmount() {
        return amount;
    }

    public String getTransID() {
        return transID;
    }

    public String getOperatorTransID() {
        return operatorTransID;
    }

    public String getClosingBal() {
        return closingBal;
    }
}
