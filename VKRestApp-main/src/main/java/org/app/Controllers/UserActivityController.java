package org.app.Controllers;

import org.app.data_base.entities.Clients;
import org.app.data_base.DataBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
public class UserActivityController {

    @Autowired
    private DataBase dataBase;

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/registration")
    public User addUser(@RequestBody User login) {
        dataBase.addUser(new Clients(login.getRole(), login.getLogin(), login.getPassword()));
        return login;
    }
    @GetMapping("/welcome")
    public String welcome() {
        return "<h2>Please, register you account at \"/api/registration\"! in Postman program</h2>";
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/{url}")
    public ResponseEntity<String> proxyRequest0(@PathVariable("url") String url) {
        String targetUrl = "https://jsonplaceholder.typicode.com/" + url;
        ResponseEntity<String> response = restTemplate.getForEntity(targetUrl, String.class);
        return response;
    }

    @PreAuthorize("hasAuthority('ROLE_POSTS') || hasAuthority('ROLE_ADMIN')")
    @GetMapping("/posts/{url}")
    public ResponseEntity<String> proxyRequest1(@PathVariable("url") String url) {
        String targetUrl = "https://jsonplaceholder.typicode.com/posts/" + url;
        ResponseEntity<String> response = restTemplate.getForEntity(targetUrl, String.class);
        return response;
    }

    @PreAuthorize("hasAuthority('ROLE_POSTS') || hasAuthority('ROLE_ADMIN')")
    @GetMapping("/posts/{url}/{url1}")
    public ResponseEntity<String> proxyRequest2(@PathVariable("url") String url, @PathVariable("url1") String url1) {
            String targetUrl = "https://jsonplaceholder.typicode.com/posts/" + url + "/" + url1;
            ResponseEntity<String> response = restTemplate.getForEntity(targetUrl, String.class);
            return response;
    }

    @PreAuthorize("hasAuthority('ROLE_ALBUMS') || hasAuthority('ROLE_ADMIN')")
    @GetMapping("/albums/{url}")
    public ResponseEntity<String> proxyRequest3(@PathVariable("url") String url) {
        String targetUrl = "https://jsonplaceholder.typicode.com/albums/" + url;
        ResponseEntity<String> response = restTemplate.getForEntity(targetUrl, String.class);
        return response;
    }

    @PreAuthorize("hasAuthority('ROLE_ALBUMS') || hasAuthority('ROLE_ADMIN')")
    @GetMapping("/albums/{url}/{url1}")
    public ResponseEntity<String> proxyRequest4(@PathVariable("url") String url, @PathVariable("url1") String url1) {
        String targetUrl = "https://jsonplaceholder.typicode.com/albums/" + url + "/" + url1;
        ResponseEntity<String> response = restTemplate.getForEntity(targetUrl, String.class);
        return response;
    }

    @PreAuthorize("hasAuthority('ROLE_USERS') || hasAuthority('ROLE_ADMIN')")
    @GetMapping("/users/{url}")
    public ResponseEntity<String> proxyRequest5 (@PathVariable("url") String url) {
        String targetUrl = "https://jsonplaceholder.typicode.com/users/" + url;
        ResponseEntity<String> response = restTemplate.getForEntity(targetUrl, String.class);
        return response;
    }

    @PreAuthorize("hasAuthority('ROLE_USERS') || hasAuthority('ROLE_ADMIN')")
    @GetMapping("/users/{url}/{url1}")
    public ResponseEntity<String> proxyRequest6 (@PathVariable("url") String url, @PathVariable("url1") String url1) {
        String targetUrl = "https://jsonplaceholder.typicode.com/users/" + url + "/" + url1;
        ResponseEntity<String> response = restTemplate.getForEntity(targetUrl, String.class);
        return response;
    }


//    @PutMapping("/{username}")
//    public Post update(@PathVariable("username") String username, @RequestBody Post post) {
//        users.stream().filter(user -> user.getUsername().equals(username)).findAny().ifPresent(user -> user.getPosts().add(post));
//        return post;
//    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @DeleteMapping("/{login}")
    public String deleteUser(@PathVariable("login") String login) {
        dataBase.deleteUser(login);
        return "User with username: " + login + " has been deleted";
    }

}
