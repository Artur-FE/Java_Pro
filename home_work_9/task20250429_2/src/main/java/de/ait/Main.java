//Ваша программа должна запрашивать номер (id) поста на сайте https://jsonplaceholder.typicode.com/
// и получить список всех комментариев для этого поста

package de.ait;

import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите номер поста от 1 до 100");
        String postId = sc.nextLine();
        String postUri = "https://jsonplaceholder.typicode.com/posts/" + postId + "/comments";
        URI uri = new URI(postUri);
        RequestEntity<String> request = new RequestEntity<>(HttpMethod.GET, uri);
        ResponseEntity<CommentsDto[]> posts = restTemplate.exchange(request, CommentsDto[].class);

        CommentsDto[] arrayComments = posts.getBody();

        for (int i = 0; i < arrayComments.length; i++) {
            if(i == 0){
                System.out.println("Все комментарии к посту № " + postId);
                System.out.println();
            }
            System.out.println(arrayComments[i]);
            System.out.println("***");
            System.out.println();
        }

    }
}