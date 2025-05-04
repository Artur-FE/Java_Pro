package de.ait;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    static String url = "https://api.apilayer.com/fixer/convert";
    static String apiKey = "NAoPxWw1ZSKIR1gscphxgF0b2cgnFFmS";
    static Scanner sc = new Scanner(System.in);
    static String fromValue;
    static String amountValue;
    static String toValue;
    static HashMap<String, Double> map = new HashMap<>();

    public static void main(String[] args) {

        converter();
        while (true) {
            System.out.println("Выполнить еще одну конвертацию? Введите ДА или НЕТ");
            if (sc.nextLine().equalsIgnoreCase("ДА")) {
                converter();
            } else break;
        }
    }

    public static void converter() {
        System.out.println("Введите валюту, которую хотите конвертировать, например USD, EUR, RUB и т.д: ");
        fromValue = sc.nextLine();
        System.out.println("Введите суммму, которую хотите конвертировать: ");
        amountValue = sc.nextLine();
        System.out.println("Введите валюту, которую хотите получить после конвертирования, например USD, EUR, RUB и т.д: ");
        toValue = sc.nextLine();
        String key = fromValue + "/" + toValue;

        if (map.containsKey(key)) {
            double result = Double.parseDouble(amountValue) * map.get(key);
            System.out.println(amountValue + " " + fromValue + " = " + result + " " + toValue);
        } else {

            String from = "from=" + fromValue;
            String to = "to=" + toValue;
            String amount = "amount=" + amountValue;

            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.add("apikey", apiKey);
            URI uri = UriComponentsBuilder.fromHttpUrl(url)
                    .queryParam(from)
                    .queryParam(to)
                    .queryParam(amount)
                    .build()
                    .toUri();
            RequestEntity<String> request = new RequestEntity<>(headers, HttpMethod.GET, uri);
            ResponseEntity<ResultDTO> response = restTemplate.exchange(request, ResultDTO.class);
            ResultDTO result = response.getBody();
            System.out.println(amountValue + " " + fromValue + " = " + result.getResult() + " " + toValue);
            map.put(key, result.getInfo().getRate());
        }
    }

}