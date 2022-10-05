package com.ajisegiri.paystack.response;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class AllCustomerResponse {
    private boolean status;
    private String message;
    List<TransactionData.Customer> data;


}
