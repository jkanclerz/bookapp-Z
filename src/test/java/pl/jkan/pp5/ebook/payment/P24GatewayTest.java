package pl.jkan.pp5.ebook.payment;


import org.junit.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class P24GatewayTest {
    private static final String MERCHANT_ID = "123456";
    private static final String CRC_CODE = "abcdefghijklmn";
    public static final String TRANSACTION_ID = "transaction_id_123456";
    public static final int MONEY = 2520;
    public static final String EMAIL = "josn.snow@example.com";

    private static final String EXPECTED_SIGN_VALUE = "58e2010290f34ffa5313b3311f783ccd";

    class SpyHttpClient implements HttpClient {
        public Map<String, String> lastParams;
        @Override
        public String post(String url, Map<String, String> params) {
            lastParams = params;
            return "OK";
        }
    }

    @Test
    public void itAllowRegisterTransaction() {
        SpyHttpClient http = new SpyHttpClient();
        P24Gateway p24Gateway = new P24Gateway(http, P24Properties.ofStatic(MERCHANT_ID, CRC_CODE));
        PaymentRequest request = thereIsPaymentRequest();
        String token = p24Gateway.register(request);

        Map<String, String> params = http.lastParams;
        assertThat(params).containsKeys(
                "p24_merchant_id",
                "p24_pos_id",
                "p24_sign");

        assertThat(params.get("p24_merchant_id")).isEqualTo(MERCHANT_ID);
        assertThat(params.get("p24_sign")).isEqualTo(EXPECTED_SIGN_VALUE);
    }

    @Test
    public void itCreateRedirectUrl() {
        SpyHttpClient http = new SpyHttpClient();
        P24Gateway p24Gateway = new P24Gateway(http, P24Properties.ofStatic(MERCHANT_ID, CRC_CODE));

        assertThat(p24Gateway.getPaymentUrl("123345")).isEqualTo(
                "https://sandbox.przelewy24.pl/trnRequest/12345"
        );
    }

    private PaymentRequest thereIsPaymentRequest() {
        return new PaymentRequest(
                EMAIL,
                MONEY,
                TRANSACTION_ID
        );
    }
}
