package com.n1b3lung0.cars.models.dao;

import com.n1b3lung0.cars.models.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICarDao extends JpaRepository<Car, Long> {
}
