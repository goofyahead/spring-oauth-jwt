package gof.kraken.restaurantservice.usecases.get_users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
class Client {
    private String name;
    // TODO think on how to ETL from different name
    private String favoriteFood;
}
