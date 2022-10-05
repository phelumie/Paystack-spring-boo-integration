package com.ajisegiri.paystack.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "paystack")
@Configuration
@Data
public class PropertiesConfiguration {

	private String initializeApi;
	private String secretKey;
	private String verifyApi;
	private String transactionApi;
	private String chargeApi;
	private String otpApi;
	private String transferApi;
	private String finalizeTransferApi;





}
