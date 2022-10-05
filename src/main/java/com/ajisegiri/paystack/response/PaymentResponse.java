package com.ajisegiri.paystack.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PaymentResponse {
    private boolean status;
    private String message;
    private InitializePaymentData data;

    @Data
    public class InitializePaymentData {
        private String authorization_url;
        private  String access_code;
        private String reference;
    }
}
