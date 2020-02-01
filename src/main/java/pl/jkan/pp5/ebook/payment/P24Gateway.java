package pl.jkan.pp5.ebook.payment;

import java.util.HashMap;
import java.util.Map;

public class P24Gateway {
    private static final String REGISTER_URL = "https://sandbox.przelewy24.pl/trnRegister";
    private HttpClient http;
    private P24Properties properties;

    public P24Gateway(HttpClient http, P24Properties properties) {
        this.http = http;
        this.properties = properties;
    }

    public String register(PaymentRequest request) {
        Map<String, String> toBeSentParams = new HashMap<>();
        toBeSentParams.put("p24_merchant_id", properties.merchantId);
        toBeSentParams.put("p24_pos_id", properties.merchantId);
        toBeSentParams.put("p24_email", request.getEmail());
        toBeSentParams.put("p24_session_id", request.getTransactionId());
        toBeSentParams.put("p24_amount", request.getMoney().toString());
        
        String response = http.post(REGISTER_URL, toBeSentParams);

        return resolveToken(response);
    }

    private String resolveToken(String response) {
        return response;
    }

    public String getPaymentUrl(String token) {
        return String.format("https://sandbox.przelewy24.pl/trnRequest/%s", token);
    }
}
