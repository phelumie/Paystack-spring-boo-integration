package com.ajisegiri.paystack.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@EqualsAndHashCode
public class Transaction {
    private Long id;
    private String event;
    private TransactionData data;

}
