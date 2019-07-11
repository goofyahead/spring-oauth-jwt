package gof.kraken.userservice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import utils.TestAuthConfig;
import utils.TokenAuthenticationTestService;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest
@Import(TestAuthConfig.class)

public class UserServiceUnitTests {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void contextLoads() {}

    @Test
    public void getUsersHomeNoAuth() throws Exception {
        List<String> roles = new ArrayList<>();
        roles.add("ROLE_USER");

        String token = TokenAuthenticationTestService.createToken("john", roles);
        assertNotNull(token);

        this.mockMvc.perform(get("/")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk());
    }

    @Test
    public void getUsersNeedAuth() throws Exception {
        List<String> roles = new ArrayList<>();
        roles.add("ROLE_USER");
        roles.add("ROLE_ADMIN");

        String token = TokenAuthenticationTestService.createToken("john", roles);
        assertNotNull(token);

        this.mockMvc.perform(get("/private")
                .header("Authorization", token)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk());
    }

    @Test
    public void getAdminPath() throws Exception {
        List<String> roles = new ArrayList<>();
        roles.add("ROLE_USER");
        roles.add("ROLE_ADMIN");

        String token = TokenAuthenticationTestService.createToken("john", roles);
        assertNotNull(token);

        this.mockMvc.perform(get("/admin")
                .header("Authorization", token)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void getArticles() throws Exception {
        List<String> roles = new ArrayList<>();
        roles.add("ROLE_USER");
        roles.add("ARTICLES_READ");

        String token = TokenAuthenticationTestService.createToken("john", roles);
        assertNotNull(token);

        this.mockMvc.perform(get("/articles")
                .header("Authorization", token)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void getM2Musers() throws Exception {
        String token = TokenAuthenticationTestService.createM2MToken("john", "b2b-message-type-A");
        assertNotNull(token);

        this.mockMvc.perform(get("/m2m/admin")
                .header("Authorization", token)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(status().isOk());
    }

}
