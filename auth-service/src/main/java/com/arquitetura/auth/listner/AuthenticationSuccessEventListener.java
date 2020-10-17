package com.arquitetura.auth.listner;

import com.arquitetura.auth.services.LoginAttemptService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@AllArgsConstructor
@Component
public class AuthenticationSuccessEventListener implements ApplicationListener<AuthenticationSuccessEvent> {
 
    private final LoginAttemptService loginAttemptService;
    private final HttpServletRequest httpServletRequest;

    public void onApplicationEvent(AuthenticationSuccessEvent e) {
        loginAttemptService.loginSucceeded(httpServletRequest.getRemoteHost());
    }

}