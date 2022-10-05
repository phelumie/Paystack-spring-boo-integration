package com.ajisegiri.paystack.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TransferDto {
    private String source;
    private String reason;
    private double amount;
    private String recipient;
}
