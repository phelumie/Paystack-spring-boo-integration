package com.ajisegiri.paystack.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class FinalizeTransfer {
    private String transfer_code;
    private String otp;
}
