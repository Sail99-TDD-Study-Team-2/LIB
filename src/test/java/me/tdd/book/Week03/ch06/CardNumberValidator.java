package me.tdd.book.Week03.ch06;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static java.net.http.HttpRequest.*;

public class CardNumberValidator {

    public CardValidity validate(String cardNumber) {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest req = newBuilder().uri(URI.create("https://some-external-pg.com/card"))
                                      .header("Content-Type", "text/plain")
                                      .POST(BodyPublishers.ofString(cardNumber))
                                      .build();

        try {
            HttpResponse<String> res = httpClient.send(req, HttpResponse.BodyHandlers.ofString());

            switch(res.body()) {
                case "ok":      return CardValidity.VALID;
                case "bad":     return CardValidity.INVALID;
                case "expired": return CardValidity.EXPIRED;
                case "theft":   return CardValidity.THEFT;
                default:        return CardValidity.UNKNOWN;
            }

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
