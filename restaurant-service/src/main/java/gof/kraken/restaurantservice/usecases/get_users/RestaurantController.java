package gof.kraken.restaurantservice.usecases.get_users;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@Slf4j
@RestController
public class RestaurantController {

    private final UserClient userClient;

    public RestaurantController(UserClient userClient) {
        this.userClient = userClient;
    }

    @GetMapping("/users")
    public List<Client> getUser() {
        log.info("called get user");
//        return Arrays.asList(new Client("Roberto", "cheese"));
        return userClient.getClients();
    }
}
