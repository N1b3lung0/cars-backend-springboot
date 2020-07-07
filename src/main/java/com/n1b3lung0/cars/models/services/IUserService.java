package com.n1b3lung0.cars.models.services;

import com.n1b3lung0.cars.models.entity.User;

public interface IUserService {

    public User findByUsername(String username);

}
