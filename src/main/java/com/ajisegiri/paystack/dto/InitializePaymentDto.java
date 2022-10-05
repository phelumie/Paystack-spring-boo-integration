package com.ajisegiri.paystack.dto;

import com.ajisegiri.paystack.enums.Currency;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InitializePaymentDto {
    @NotBlank
    @NotNull
    @Email
    private String email;
    @NotNull
    private double amount;
    private Currency currency;
}
