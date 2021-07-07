package com.example.webprojectpro.Events;

import com.example.webprojectpro.enums.Role;
import com.example.webprojectpro.models.entities.User;
import com.example.webprojectpro.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.nio.CharBuffer;

@Component
@RequiredArgsConstructor
@Slf4j
public class InitialAdminAccountEvent {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @EventListener(ApplicationReadyEvent.class)
    public void createFirstAdminAccount() {

        if(!isAnyUserInDatabase()){
            User admin = createAdminAccount();

            userRepository.save(admin);
            log.info("First admin account saved!");
        }
    }

    private User createAdminAccount() {

        final char[] encodedPassword = passwordEncoder.encode(CharBuffer.wrap("admin")).toCharArray();

        return User.builder()
                    .email("WebProProjectAdmin@gmail.com")
                    .password(encodedPassword)
                    .role(Role.ADMIN)
                    .firstName("Jan")
                    .lastName("Prokop")
                .build();
    }

    private boolean isAnyUserInDatabase() {
        return userRepository.count() > 0;
    }


}
