package com.ajisegiri.paystack.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SubmitOtp {
//    https://api.paystack.co/charge/submit_otp
    private String otp;
    private String reference;
}
