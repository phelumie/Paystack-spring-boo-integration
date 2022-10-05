package com.ajisegiri.paystack.service;

import com.ajisegiri.paystack.dto.*;
import com.ajisegiri.paystack.response.PaymentResponse;
import com.ajisegiri.paystack.response.AllTransactionResponse;
import com.ajisegiri.paystack.response.TransactionResponse;
import com.ajisegiri.paystack.response.VerifyTransactionResponse;
import reactor.core.publisher.Mono;

public interface PayStackService {
    Mono<PaymentResponse> initializePayment(InitializePaymentDto initializePaymentDto);

    Mono<TransactionResponse> bankChargeApi(BankChargeApi bankChargeApi);

    Mono<TransactionResponse> transfer(TransferDto transferDto);

    Mono<TransactionResponse> finalizeTransfer(FinalizeTransfer finalizeTransfer);

    Mono<TransactionResponse> submitOtp(SubmitOtp submitOtp);

    Mono<VerifyTransactionResponse> verifyTransaction(String reference);
    Mono<AllTransactionResponse> getAllTransactions();
}
