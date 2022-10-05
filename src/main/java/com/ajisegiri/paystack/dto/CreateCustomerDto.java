package com.ajisegiri.paystack.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
@Data
@NoArgsConstructor
public class CreateCustomerDto {
    @Email
    private String email;
    private String firstName;
    private String lastName;
    private String phone;
}
