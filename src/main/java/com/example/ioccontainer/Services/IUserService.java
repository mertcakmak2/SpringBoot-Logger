package com.example.ioccontainer.Services;

import com.example.ioccontainer.Entities.User;

public interface IUserService {

    User saveUser(User user);
    User deleteUser(User user) throws Exception;
}
