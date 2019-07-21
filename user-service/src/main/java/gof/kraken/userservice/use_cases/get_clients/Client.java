package gof.kraken.userservice.use_cases.get_clients;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
class Client {
    private String name;
    private String clientId;
    private String favoriteFood;
}
