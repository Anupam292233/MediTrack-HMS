package com.hms.payload;

import lombok.Data;

@Data
public class BillingDTO {
    private String insuranceProvider;
    private String policyNumber;
    private double totalAmount;

}