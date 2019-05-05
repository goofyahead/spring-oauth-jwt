package gof.kraken.userservice.config;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@EnableResourceServer
//@RestController
@Configuration
//@EnableOAuth2Sso
//@Order(value = 10)
public class ResourceServerConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/", "/login").permitAll()
                .and().authorizeRequests().anyRequest().authenticated();

//        http.requestMatchers().antMatchers("/private") // Deny access to "/ private"
//                .and().authorizeRequests()
//                .antMatchers("/private").access("hasRole ('USER')")
//                .and()
//                .requestMatchers().antMatchers("/admin") // Deny access to "/ admin"
//                .and()
//                .authorizeRequests().antMatchers("/admin").access("hasRole('ADMIN')");
    }
}
