package com.n1b3lung0.cars.models.services;

import com.n1b3lung0.cars.models.entity.Car;

import java.util.List;
import java.util.Optional;

public interface ICarService {

    public List<Car> findAll();
    public Car findById(Long id);
    public Car save(Car car);
    public void delete(Long id);
}
