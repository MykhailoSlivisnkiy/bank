package com.bank.application.security.service;

import com.bank.application.constant.ErrorMessages;
import com.bank.application.model.User;
import com.bank.application.repository.UserRepository;
import com.bank.application.security.entity.ApplicationUser;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ApplicationUserService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findAllByUsername(username).orElseThrow(
                () -> new UsernameNotFoundException(String.format(ErrorMessages.USER_WAS_NOT_FOUND_BY_USERNAME, username)));

        return ApplicationUser.create(user);
    }
}
