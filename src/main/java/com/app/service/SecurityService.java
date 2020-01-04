package com.app.service;

import com.app.dto.RegisterDto;
import com.app.exception.AppException;
import com.app.model.User;
import com.app.repository.RoleRepository;
import com.app.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class SecurityService {

    private final UserRepository userRepository;
    private RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public Long register(RegisterDto registerDto) {
        if (registerDto == null) {
            throw new AppException("Register is null");
        }
        if (userRepository.findByUsername(registerDto.getUsername()).isPresent()) {
            throw new AppException("User with username: " + registerDto.getUsername() + " already exist");
        }
        if (!Objects.equals(registerDto.getPassword(), registerDto.getPasswordConfirmation())) {
            throw new AppException("passwords are not equal");
        }

        User user = User.builder()
                .username(registerDto.getUsername())
                .password(registerDto.getPassword())
                .roles(registerDto.getRoles()
                        .stream()
                        .map(roleStr -> roleRepository
                                .findByName(roleStr)
                                .orElseThrow(() -> new AppException("no role with name " + roleStr + ".")))
                        .collect(Collectors.toSet()))
                .build();
        return userRepository.save(user).getId();
    }

}
