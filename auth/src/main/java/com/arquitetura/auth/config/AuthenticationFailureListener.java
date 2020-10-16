package com.arquitetura.auth.config;

import com.arquitetura.auth.services.LoginAttemptService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
@RequiredArgsConstructor
public class AuthenticationFailureListener implements ApplicationListener<AuthenticationFailureBadCredentialsEvent> {
 
    private final LoginAttemptService loginAttemptService;
    private final HttpServletRequest httpServletRequest;

    public void onApplicationEvent(AuthenticationFailureBadCredentialsEvent e) {
        loginAttemptService.loginFailed(httpServletRequest.getRemoteHost());
    }

}
