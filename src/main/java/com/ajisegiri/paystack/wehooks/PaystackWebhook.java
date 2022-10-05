package com.ajisegiri.paystack.wehooks;

import com.ajisegiri.paystack.config.PropertiesConfiguration;
import com.ajisegiri.paystack.exceptions.UnAuthorizedException;
import com.ajisegiri.paystack.response.Transaction;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.HmacAlgorithms;
import org.apache.commons.codec.digest.HmacUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static java.util.Objects.isNull;

@RestController
@RequestMapping("api")
@Slf4j
@RequiredArgsConstructor
public class PaystackWebhook {
    private final PropertiesConfiguration prop;
    private final ObjectMapper objectMapper;

    @PostMapping("paystack/events")
    public ResponseEntity handlePaystackEvents(@RequestBody Object data, @RequestHeader("x-paystack-signature") String header) throws JsonProcessingException {
        log.debug("paystack webhook called with body {}",data);

        if (isNull(header)){
            log.error("header can not be empty");
            throw new UnAuthorizedException("unauthorized url");
        }

        var json=objectMapper.writeValueAsString(data);

        String hash = new HmacUtils(HmacAlgorithms.HMAC_SHA_512, prop.getSecretKey()).hmacHex(json);

        if (!hash.equals(header)) {
            log.error("webhook error unable to validate signature");
            throw new UnAuthorizedException("invalid signature");
        }
        Transaction body=objectMapper.readValue(json, Transaction.class);

        switch (body.getEvent()){
            case "charge.success":
                log.info("do something for this event");
                break;
            case "invoice.payment_failed":
                log.info("do something for this event");
                break;

        }
        return new ResponseEntity(HttpStatus.OK);
    }

}
