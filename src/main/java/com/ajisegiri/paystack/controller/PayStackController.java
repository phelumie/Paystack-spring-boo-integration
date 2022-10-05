package com.ajisegiri.paystack.controller;

import com.ajisegiri.paystack.dto.*;
import com.ajisegiri.paystack.response.*;
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

    @PostMapping("customer")
    public ResponseEntity<Mono<CustomerResponse>> createCustomer(@RequestBody @Valid CreateCustomerDto customerDto){
        var result=payStackService.createCustomer(customerDto);
        return new ResponseEntity<>(result,HttpStatus.CREATED);
    }
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

    @GetMapping("customer")
    public ResponseEntity<Mono<CustomerResponse>> getCustomer(@RequestParam("customer-code") String id){
        var result=payStackService.getCustomerById(id);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }
    @GetMapping("transaction")
    public ResponseEntity<Mono<TransactionResponse>> getTransaction(@RequestParam("transaction-id") String id){
        var result=payStackService.getTransactionById(id);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    @GetMapping("customers")
    public ResponseEntity<Mono<AllCustomerResponse>> getAllCustomers(){
        var result=payStackService.getAllCustomers();
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    @GetMapping("transactions")
    public ResponseEntity<Mono<AllTransactionResponse>> getAllTransactions(){
        var result=payStackService.getAllTransactions();
        return new ResponseEntity<>(result,HttpStatus.OK);
    }



}
