package com.polytech.polyNet.application;

import com.polytech.polyNet.object.Users;
import com.polytech.polyNet.repository.UserRepository;

public class RegisterServiceImpl implements RegisterService {

    private UserRepository userRepository;

    public RegisterServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void register(Users u) {

    }
}
