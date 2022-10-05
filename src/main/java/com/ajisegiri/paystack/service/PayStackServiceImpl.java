package com.ajisegiri.paystack.service;

import com.ajisegiri.paystack.config.PropertiesConfiguration;
import com.ajisegiri.paystack.dto.*;
import com.ajisegiri.paystack.exceptions.PayStackExceptions;
import com.ajisegiri.paystack.response.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@Slf4j
public class PayStackServiceImpl implements PayStackService{
    private final WebClient.Builder webClient;
    private final ObjectMapper objectMapper;
    private final PropertiesConfiguration prop;
    @Override
    public Mono<CustomerResponse> createCustomer(CreateCustomerDto createCustomerDto) {
        log.debug("entering method createCustomer");
        log.info("creating paystack customer account  for {}",createCustomerDto.toString());
        return webClient.build().post().uri(prop.getCustomerApi())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .headers(httpHeaders -> httpHeaders.setBearerAuth(prop.getSecretKey()))
                .bodyValue(createCustomerDto)
                .retrieve()
                .onStatus(HttpStatus::isError, clientResponse -> clientResponse
                        .bodyToMono(String.class)
                        .flatMap(error -> {
                            log.error("{} resulted into error: {}",createCustomerDto.toString(),error);
                            return Mono.error(new PayStackExceptions(error));
                        }))
                .bodyToMono(CustomerResponse.class);
    }
    @Override
    public Mono<PaymentResponse> initializePayment(InitializePaymentDto initializePaymentDto) {
        log.debug("entering method initializePayment");
        initializePaymentDto.setAmount(initializePaymentDto.getAmount()*100);
        log.info("initializing payment for {}",initializePaymentDto.toString());
        return webClient.build().post().uri(prop.getInitializeApi())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .headers(httpHeaders -> httpHeaders.setBearerAuth(prop.getSecretKey()))
                .bodyValue(initializePaymentDto)
                .retrieve()
                .onStatus(HttpStatus::isError, clientResponse -> clientResponse
                        .bodyToMono(String.class)
                        .flatMap(error -> {
                            log.error("{} resulted into error: {}",initializePaymentDto.toString(),error);
                            return Mono.error(new PayStackExceptions(error));
                        }))
                .bodyToMono(PaymentResponse.class);
    }

    @Override
    public Mono<TransactionResponse> bankChargeApi(BankChargeApi bankChargeApi) {
        log.debug("entering method bankChargeApi");
        bankChargeApi.setAmount(bankChargeApi.getAmount()*100);
        log.info("initializing charge payment for {}",bankChargeApi.toString());
        return webClient.build().post().uri(prop.getChargeApi())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .headers(httpHeaders -> httpHeaders.setBearerAuth(prop.getSecretKey()))
                .bodyValue(bankChargeApi)
                .retrieve()
                .onStatus(HttpStatus::isError, clientResponse -> clientResponse
                        .bodyToMono(String.class)
                        .flatMap(error -> {
                            log.error("{} resulted into error: {}",bankChargeApi.toString(),error);
                            return Mono.error(new PayStackExceptions(error));
                        }))
                .bodyToMono(TransactionResponse.class);
    }

    @Override
    public Mono<TransactionResponse> transfer(TransferDto transferDto) {
        log.debug("entering method transferDto");
        transferDto.setAmount(transferDto.getAmount()*100);
        log.info("initializing charge payment for {}",transferDto.toString());
        return webClient.build().post().uri(prop.getTransferApi())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .headers(httpHeaders -> httpHeaders.setBearerAuth(prop.getSecretKey()))
                .bodyValue(transferDto)
                .retrieve()
                .onStatus(HttpStatus::isError, clientResponse -> clientResponse
                        .bodyToMono(String.class)
                        .flatMap(error -> {
                            log.error("{} resulted into error: {}",transferDto.toString(),error);
                            return Mono.error(new PayStackExceptions(error));
                        }))
                .bodyToMono(TransactionResponse.class);
    }

    @Override
    public Mono<TransactionResponse> finalizeTransfer(FinalizeTransfer finalizeTransfer) {
        log.debug("entering method finalizeTransfer");
        log.info("initializing charge payment for {}",finalizeTransfer.toString());
        return webClient.build().post().uri(prop.getFinalizeTransferApi())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .headers(httpHeaders -> httpHeaders.setBearerAuth(prop.getSecretKey()))
                .bodyValue(finalizeTransfer)
                .retrieve()
                .onStatus(HttpStatus::isError, clientResponse -> clientResponse
                        .bodyToMono(String.class)
                        .flatMap(error -> {
                            log.error("{} resulted into error: {}",finalizeTransfer.toString(),error);
                            return Mono.error(new PayStackExceptions(error));
                        }))
                .bodyToMono(TransactionResponse.class);
    }

    @Override
    public Mono<TransactionResponse> submitOtp(SubmitOtp submitOtp) {
        log.debug("entering method submitOtp");
        log.info("initializing charge payment for {}",submitOtp.toString());
        return webClient.build().post().uri(prop.getOtpApi())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .headers(httpHeaders -> httpHeaders.setBearerAuth(prop.getSecretKey()))
                .bodyValue(submitOtp)
                .retrieve()
                .onStatus(HttpStatus::isError, clientResponse -> clientResponse
                        .bodyToMono(String.class)
                        .flatMap(error -> {
                            log.error("{} resulted into error: {}",submitOtp.toString(),error);
                            return Mono.error(new PayStackExceptions(error));
                        }))
                .bodyToMono(TransactionResponse.class);
    }

    @Override
    public Mono<VerifyTransactionResponse> verifyTransaction(String reference) {
        log.debug("entering method verifyTransaction");
        String url=prop.getVerifyApi().concat("/").concat(reference);
        return webClient.build().get().uri(url)
                .accept(MediaType.APPLICATION_JSON)
                .headers(httpHeaders -> httpHeaders.setBearerAuth(prop.getSecretKey()))
                .retrieve()
                .onStatus(HttpStatus::isError, clientResponse -> clientResponse
                        .bodyToMono(String.class)
                        .flatMap(error -> {
                            log.error("{} resulted into error: {}",reference,error);
                            return Mono.error(new PayStackExceptions(error));}))
                .bodyToMono(VerifyTransactionResponse.class);

    }
    @Override
    public Mono<AllTransactionResponse> getAllTransactions() {
        log.debug("entering method getAllTransactions");
        return webClient.build().get().uri(prop.getTransactionApi())
                .accept(MediaType.APPLICATION_JSON)
                .headers(httpHeaders -> httpHeaders.setBearerAuth(prop.getSecretKey()))
                .retrieve()
                .onStatus(HttpStatus::isError, clientResponse -> clientResponse
                        .bodyToMono(String.class)
                        .flatMap(error -> {
                            log.error("getAllTransactions resulted into error: {}",error);
                            return Mono.error(new PayStackExceptions(error));}))
                .bodyToMono(AllTransactionResponse.class);
    }

    @Override
    public Mono<AllCustomerResponse> getAllCustomers() {
        log.debug("entering method getAllCustomers");
        return webClient.build().get().uri(prop.getCustomerApi())
                .accept(MediaType.APPLICATION_JSON)
                .headers(httpHeaders -> httpHeaders.setBearerAuth(prop.getSecretKey()))
                .retrieve()
                .onStatus(HttpStatus::isError, clientResponse -> clientResponse
                        .bodyToMono(String.class)
                        .flatMap(error -> {
                            log.error("getAllCustomers resulted into error: {}",error);
                            return Mono.error(new PayStackExceptions(error));}))
                .bodyToMono(AllCustomerResponse.class);
    }

    @Override
    public Mono<TransactionResponse> getTransactionById(String id) {
        log.debug("entering method getTransactionById");
        String url=prop.getTransactionApi().concat("/").concat(id);
        return webClient.build().get().uri(url)
                .accept(MediaType.APPLICATION_JSON)
                .headers(httpHeaders -> httpHeaders.setBearerAuth(prop.getSecretKey()))
                .retrieve()
                .onStatus(HttpStatus::isError, clientResponse -> clientResponse
                        .bodyToMono(String.class)
                        .flatMap(error -> {
                            log.error("getAllTransaction  by id {} resulted into error: {}",id,error);
                            return Mono.error(new PayStackExceptions(error));}))
                .bodyToMono(TransactionResponse.class);
    }
    @Override
    public Mono<CustomerResponse> getCustomerById(String customerCode) {
        log.debug("entering method getCustomerById");
        String url=prop.getCustomerApi().concat("/").concat(customerCode);
        return webClient.build().get().uri(url)
                .accept(MediaType.APPLICATION_JSON)
                .headers(httpHeaders -> httpHeaders.setBearerAuth(prop.getSecretKey()))
                .retrieve()
                .onStatus(HttpStatus::isError, clientResponse -> clientResponse
                        .bodyToMono(String.class)
                        .flatMap(error -> {
                            log.error("getCustomer by id {} resulted into error: {}",customerCode,error);
                            return Mono.error(new PayStackExceptions(error));}))
                .bodyToMono(CustomerResponse.class);
    }

}
