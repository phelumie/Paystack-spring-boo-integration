package com.ajisegiri.paystack.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CustomerResponse {
    private boolean status;
    private String message;
    private TransactionData.Customer data;
}
