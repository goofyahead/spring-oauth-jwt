package gof.kraken.userservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class UserController {

    @RequestMapping("/")
    public String home() {
        return "Hello, welcome user home";
    }

    @RequestMapping("/private")
    public String privatePage(Principal user) {
        return "Wow you are allowed here? Hello " + user.getName();
    }

    @RequestMapping("/admin")
    public String adminPage(Principal user) {
        return "GASP! you are and ADMIN? Hello " + user.getName();
    }
}
