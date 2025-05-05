//Ваша задача написать программу, которая получает List комментариев (объекты коллекции)
// comments на сайте https://jsonplaceholder.typicode.com/

package de.ait;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        URI uri = new URI("https://jsonplaceholder.typicode.com/comments");
        RequestEntity<String> request = new RequestEntity<>(HttpMethod.GET, uri);
        ResponseEntity<ArrayList<CommentDto>> comments = restTemplate.exchange(request, new ParameterizedTypeReference<ArrayList<CommentDto>>() {});
        ArrayList<CommentDto> commentsList = comments.getBody();
        for(CommentDto comment : commentsList) {
            System.out.println(comment);
            System.out.println();
        }
    }
}