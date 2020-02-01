package pl.jkan.pp5.ebook.payment;

import java.util.Map;

public interface HttpClient {
    String post(String url, Map<String, String> params);
}
