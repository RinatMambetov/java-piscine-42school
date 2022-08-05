package edu.school21.sockets.services;

import org.springframework.stereotype.Component;

@Component
public interface UserService {
    String signUp(String username, String password);
}
