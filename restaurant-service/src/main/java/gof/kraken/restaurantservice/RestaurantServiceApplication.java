package gof.kraken.restaurantservice;

import feign.RequestInterceptor;
import gof.kraken.restaurantservice.config.FeignInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
public class RestaurantServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestaurantServiceApplication.class, args);
    }

    @Bean
    public RequestInterceptor getUserFeignClientInterceptor() {
        return new FeignInterceptor();
    }

}
