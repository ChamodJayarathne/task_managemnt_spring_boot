package com.chamod.taskmanager.service;

import com.chamod.taskmanager.dto.request.RequestUserDto;

public interface UserService {

    public String signup(RequestUserDto userDto);

}
