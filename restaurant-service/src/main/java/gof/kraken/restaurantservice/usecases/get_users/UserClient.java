package gof.kraken.restaurantservice.usecases.get_users;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "clients", url = "http://localhost:8673/users")
public interface UserClient {

    @RequestMapping(method = RequestMethod.GET, value = "/clients")
    List<Client> getClients();

    //    @RequestMapping(method = RequestMethod.POST, value = "/stores/{storeId}", consumes = "application/json")
    //    Store update(@PathVariable("storeId") Long storeId, Store store);

}
