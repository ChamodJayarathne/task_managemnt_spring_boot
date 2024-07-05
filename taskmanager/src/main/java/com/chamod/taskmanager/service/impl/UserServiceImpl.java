package com.chamod.taskmanager.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.chamod.taskmanager.dto.request.RequestUserDto;
import com.chamod.taskmanager.entity.User;
import com.chamod.taskmanager.repo.UserRepo;
import com.chamod.taskmanager.service.UserService;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

        private final PasswordEncoder passwordEncoder;
        private final UserRepo userRepo;

        @Override
        public String signup(RequestUserDto userDto) {
            User user = new User(
                    null, userDto.getUsername(),
                    passwordEncoder.encode(userDto.getPassword()),
                    userDto.getRole()
                    );

            userRepo.save(user);
            return user.getUsername()+ " saved";
        }

    }