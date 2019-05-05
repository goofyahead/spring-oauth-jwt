package gof.kraken.gatewayservice.config;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;

import javax.servlet.http.HttpSession;

public class AuthHeaderFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext context = RequestContext.getCurrentContext();

        HttpSession session = RequestContext.getCurrentContext().getRequest().getSession(false);
        if (session == null) {
            return null;
        }

        DefaultOAuth2ClientContext authDetails = (DefaultOAuth2ClientContext) session.getAttribute("scopedTarget.oauth2ClientContext");

        if (authDetails.getAccessToken() != null) {
            context.addZuulRequestHeader("Authorization", "Bearer " + authDetails.getAccessToken().getValue());
        }

        return null;
    }

}