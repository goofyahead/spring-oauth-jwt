package gof.kraken.userservice.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController()
@PreAuthorize("#oauth2.hasScope('b2b-message-type-A')")
public class M2MUserController {

    @RequestMapping("/m2m/users")
    public String privatePage(Principal user) {
        return "Wow you are allowed here? Hello machine " + user.getName();
    }

    @RequestMapping("/m2m/admin")
    public String adminPage(Principal user) {
        return "GASP! you are and ADMIN? Hello machine " + user.getName();
    }

}
