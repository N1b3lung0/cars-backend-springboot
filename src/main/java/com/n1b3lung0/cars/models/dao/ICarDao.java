package com.n1b3lung0.cars.models.dao;

import com.n1b3lung0.cars.models.entity.Car;
import org.springframework.data.repository.CrudRepository;

public interface ICarDao extends CrudRepository<Car, Long> {
}
