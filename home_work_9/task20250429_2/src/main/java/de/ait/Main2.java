////Ваша программа должна запрашивать номер (id) поста на сайте https://jsonplaceholder.typicode.com/
//// и получить список всех комментариев для этого поста
//
//package de.ait;
//
//import org.springframework.http.HttpMethod;
//import org.springframework.http.RequestEntity;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.client.RestTemplate;
//
//import java.net.URI;
//import java.net.URISyntaxException;
//import java.util.ArrayList;
//
//public class Main2 {
//    public static void main(String[] args) throws URISyntaxException {
//        RestTemplate restTemplate = new RestTemplate();
//        URI uri = new URI("https://jsonplaceholder.typicode.com/posts");
//        RequestEntity<String> request = new RequestEntity<>(HttpMethod.GET, uri);
//        ResponseEntity<PostDto[]> posts = restTemplate.exchange(request, PostDto[].class);
//
//        PostDto[] arrayIdPosts = posts.getBody();
//
//        for (PostDto post : arrayIdPosts) {
//            String url = "https://jsonplaceholder.typicode.com/posts/" + post + "/comments";
//            URI postUri = new URI("postUri");
//           RequestEntity<String> requestComment = new RequestEntity<>(HttpMethod.GET, postUri);
//
//        }
//
//
//
//
//    }
//}