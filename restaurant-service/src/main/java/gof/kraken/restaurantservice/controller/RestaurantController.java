package gof.kraken.restaurantservice.controller;

import gof.kraken.restaurantservice.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping(path = "/restaurant", produces = "application/json")
public class RestaurantController {

    private final WebClient.Builder wcBuilder;

    public RestaurantController(WebClient.Builder wcBuilder) {
        this.wcBuilder = wcBuilder;
    }

    @GetMapping
    public Mono<User> getUser() {
        log.info("called get user");
        return wcBuilder
                .build()
                .get()
                .uri("http://user-service/user")
                .retrieve()
                .bodyToMono(User.class);
    }
}
