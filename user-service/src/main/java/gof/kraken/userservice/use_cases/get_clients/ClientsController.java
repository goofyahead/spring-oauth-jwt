package gof.kraken.userservice.use_cases.get_clients;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class ClientsController {

    @GetMapping("/clients")
    public List<Client> getClients() {
        return Arrays.asList(new Client("Alex", "1234", "Cheese"), new Client("Gustav", "1235", "Almond"));
    }
}
