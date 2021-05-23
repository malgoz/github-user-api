package pl.kinert.malgorzata.github.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import pl.kinert.malgorzata.github.model.User;
import pl.kinert.malgorzata.github.service.UserService;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequiredArgsConstructor
public class GithubUserController {

    private final UserService userService;

    @Value("${github.api.url}")
    private String githubApiUrl;

    @GetMapping("/users/{login}")
    public User getUser(@PathVariable String login) throws URISyntaxException {
        URI uri = new URI(githubApiUrl + "/users/" + login);
        User user = new RestTemplate().getForObject(
                uri,
                User.class);
        user.setCalculations(userService.calculateUserData(user.getFollowers(), user.getPublicRepos()));
        return user;
    }
}
