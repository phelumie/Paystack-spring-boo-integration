package com.ajisegiri.paystack.response;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
public class VerifyTransactionResponse {
    private boolean status;
    private String message;
    private VerifyTransactionResponseData data;

    @Data
    public class VerifyTransactionResponseData {
        private Long id;
        private String domain;
        private String status;
        private String reference;
        private BigDecimal amount;
        private String message;
        private String gateway_response;
        private Date paid_at;
        private Date created_at;
        private String channel;
        private String currency;
        private String ip_address;
    }
}
