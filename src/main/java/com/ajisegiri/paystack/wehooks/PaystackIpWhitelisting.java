package com.ajisegiri.paystack.wehooks;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class PaystackIpWhitelisting implements HandlerInterceptor  {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String ipAddress=request.getRemoteAddr();

        // to be enabled in live mode or better still use spring security
//                if (isPayStackIp(ipAddress)) {
//                    throw new UnAuthorizedException("Ip not authorized");
//        }
        return true;
    }

    private static boolean isPayStackIp(String ipAddress) {
        return !ipAddress.equals("52.31.139.75") || ipAddress.equals("52.49.173.169") || ipAddress.equals("52.214.14.220");
    }

}
