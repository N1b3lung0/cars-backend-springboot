package com.n1b3lung0.cars.models.dao;

import com.n1b3lung0.cars.models.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IUserDao extends CrudRepository<User, Long> {

    @Query("select u from User u where u.username=?1")
    public User findByUsername(String username);
}
