# Paystack-spring-boot-integration

Access to [Paystack Api](https://paystack.com/docs/api/)

This project is a Spring boot-built RESTful API that handles transactions with Paystack integration.

Before we proceed, an environment variable must be set for pasystack o identify and authorize you.

```
                                   PAYSTACK_SECRET_KEY=your api key given by paystack
```



## API calls documentation

### Paystack
* POST ``` /api/v1/customer ```  -create customer account with paystack.
* POST ``` /api/v1/initialize ```  -initializes payment and generate payment link.
* POST ``` /api/v1/charge ```  -Initiate a payment by integrating the payment channel of your choice.
* POST ``` /api/v1/submit-otp ```  -Submit OTP to complete a charge.
* POST ``` /api/v1/transfer ```  -Transfer funds.
* POST ``` /api/v1/finalize-transfer ```  -Finalize an initiated transfer.
* GET ``` /api/v1/customer ``` -get all customers.
* GET ``` /api/v1/customer?customer-code=CUSTOMER_CODE ``` -get customer by their cusomer code.
* GET ``` /api/v1/verify?reference=REFERENCE_CODE ``` -Confirm the status of a transaction.
* GET ``` /api/v1/transactions ``` -List transactions carried out.
* GET ``` /api/v1/transaction?transaction-id=TRANSACTION_ID ``` -get customer by their cusomer code

```
        CUSTOMER_CODE (REQUIRE): The id of the customer.
        REFERENCE_CODE(REQUIRE): The reference code of the transaction.
        TRANSACTION_ID(REQUIRE): The id of the transaction.
```
### Webhook

* POST ``` /api/paystack/events -H 'x-paystack-signature: HEADER ```

```
        HEADER (REQUIRE): The header of the event. If not present unauthorized exception is thrown. If header is not equals to hash genereated an unauhorized exception is also thrown. 
```

## Swagger OpenApi url
```
http://localhost:8080/swagger-ui/index.html 
```
## Author
Sunday Ajisegiri (ajisegiris1@gmail.com).
