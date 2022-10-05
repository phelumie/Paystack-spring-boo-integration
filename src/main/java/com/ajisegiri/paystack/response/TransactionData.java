package com.ajisegiri.paystack.response;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
public class TransactionData {
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
        private String timeline ;
        Customer customer;
        Authorization authorization;
        Object plan;
        private BigDecimal requested_amount;

        @Data
        public static class Customer {
        private String first_name;
        private String last_name;
        private String email;
        private String phone;
        private String customer_code;
    }
    @Data
    public static class Authorization{
            private String authorization_code;
            private String bin;
            private String last4;
            private String exp_month;
            private String exp_year;
            private String card_type;
            private String bank;
            private String country_code;
            private String brand;
            private String account_name;
    }
}
