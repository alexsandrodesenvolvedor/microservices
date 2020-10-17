package com.arquitetura.auth.services;

import com.arquitetura.auth.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * @author alexsandro
 * <p>
 * Classe de negócio de User
 */

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final LoginAttemptService loginAttemptService;
    private final HttpServletRequest request;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String ip = getClientIP();
        if (loginAttemptService.isBlocked(ip)) {
            throw new BadCredentialsException("blocked");
        }
        var user = userRepository.findByUserName(username);
        if (user.isPresent()) {
            return user.get();
        } else {
            throw new BadCredentialsException(" Username or password invalid");
        }
    }

    private String getClientIP() {
        return request.getRemoteHost();
    }

}
