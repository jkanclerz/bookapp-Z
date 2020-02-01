package pl.jkan.pp5.ebook.payment;

public class P24Properties {
    String merchantId;
    String crcCode;

    public P24Properties(String merchantId, String crcCode) {
        this.merchantId = merchantId;
        this.crcCode = crcCode;
    }
    public static P24Properties ofStatic(String merchantId, String crcCode) {
        return new P24Properties(merchantId, crcCode);
    }

    public static P24Properties ofEnvironment() {
        return new P24Properties(
                System.getenv("P24_MERCHANT_ID"),
                System.getenv("P24_CRC"));
    }
}
