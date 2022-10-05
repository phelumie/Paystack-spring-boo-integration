package com.ajisegiri.paystack.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class BankChargeApi {
    private String email;
    private double amount;
    private Metadata metadata;
    private Bank bank;
    private LocalDate birthday;
    @Data
    public static class Metadata {
        private String value;
        private String display_name;
        private String variable_name;
    }
    @Data
    public static class Bank {
        private String code;
        private String account_number;
    }
}
