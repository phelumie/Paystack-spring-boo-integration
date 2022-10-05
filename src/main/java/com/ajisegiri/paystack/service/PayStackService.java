package com.ajisegiri.paystack.service;

import com.ajisegiri.paystack.dto.*;
import com.ajisegiri.paystack.response.*;
import reactor.core.publisher.Mono;

public interface PayStackService {
    Mono<CustomerResponse> createCustomer(CreateCustomerDto createCustomerDto);

    Mono<PaymentResponse> initializePayment(InitializePaymentDto initializePaymentDto);

    Mono<TransactionResponse> bankChargeApi(BankChargeApi bankChargeApi);

    Mono<TransactionResponse> transfer(TransferDto transferDto);

    Mono<TransactionResponse> finalizeTransfer(FinalizeTransfer finalizeTransfer);

    Mono<TransactionResponse> submitOtp(SubmitOtp submitOtp);

    Mono<VerifyTransactionResponse> verifyTransaction(String reference);
    Mono<AllTransactionResponse> getAllTransactions();

    Mono<AllCustomerResponse> getAllCustomers();

    Mono<TransactionResponse> getTransactionById(String id);

    Mono<CustomerResponse> getCustomerById(String customerCode);
}
