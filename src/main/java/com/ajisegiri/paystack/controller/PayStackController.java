package com.ajisegiri.paystack.controller;

import com.ajisegiri.paystack.dto.*;
import com.ajisegiri.paystack.response.PaymentResponse;
import com.ajisegiri.paystack.response.AllTransactionResponse;
import com.ajisegiri.paystack.response.TransactionResponse;
import com.ajisegiri.paystack.response.VerifyTransactionResponse;
import com.ajisegiri.paystack.service.PayStackService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1")
public class PayStackController {
    private final PayStackService payStackService;

    @PostMapping("initialize")
    public ResponseEntity<Mono<PaymentResponse>> initializePayment(@RequestBody @Valid InitializePaymentDto initializePayment){
        var result=payStackService.initializePayment(initializePayment);
        return new ResponseEntity<>(result,HttpStatus.CREATED);
    }

    @PostMapping("charge")
    public ResponseEntity<Mono<TransactionResponse>> chargePayment(@RequestBody @Valid BankChargeApi bankCharge){
        var result=payStackService.bankChargeApi(bankCharge);
        return new ResponseEntity<>(result,HttpStatus.CREATED);
    }
    @PostMapping("transfer")
    public ResponseEntity<Mono<TransactionResponse>> transfer(@RequestBody @Valid TransferDto transferDto){
        var result=payStackService.transfer(transferDto);
        return new ResponseEntity<>(result,HttpStatus.CREATED);
    }
    @PostMapping("finalize-transfer")
    public ResponseEntity<Mono<TransactionResponse>> finalizeTransfer(@RequestBody @Valid FinalizeTransfer finalizeTransfer){
        var result=payStackService.finalizeTransfer(finalizeTransfer);
        return new ResponseEntity<>(result,HttpStatus.CREATED);
    }
    @PostMapping("submit-otp")
    public ResponseEntity<Mono<TransactionResponse>> submitOtp(@RequestBody @Valid SubmitOtp otp){
        var result=payStackService.submitOtp(otp);
        return new ResponseEntity<>(result,HttpStatus.CREATED);
    }
    @GetMapping("verify")
    public ResponseEntity<Mono<VerifyTransactionResponse>> verifyTransaction(@RequestParam("reference") String reference){
        var result=payStackService.verifyTransaction(reference);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    @GetMapping("transactions")
    public ResponseEntity<Mono<AllTransactionResponse>> getAllTransactions(){
        var result=payStackService.getAllTransactions();
        return new ResponseEntity<>(result,HttpStatus.OK);
    }



}
