package com.ajisegiri.paystack.response;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class TransactionResponse {
    private boolean status;
    private String message;
    TransactionData data;


}
