package com.n1b3lung0.cars.controllers;

import com.n1b3lung0.cars.models.entity.Car;
import com.n1b3lung0.cars.models.services.ICarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/cars")
public class CarRestController {

    @Autowired
    private ICarService carService;

    @GetMapping(value = { "", "/" })
    public List<Car> index() {
        return carService.findAll();
    }

    @GetMapping(value="/{id}")
    public Car show(@PathVariable Long id) {
        return carService.findById(id);
    }

    @PostMapping(value={ "", "/" })
    public Car create(@RequestBody Car car) {
        return carService.save(car);
    }

    @PutMapping(value="/{id}")
    public Car update(@RequestBody Car car, @PathVariable Long id) {
        return carService.save(car.UpdateCar(carService.findById(id), car));
    }

    @DeleteMapping(value="{id}")
    public void delete(@PathVariable Long id) {
        carService.delete(id);
    }

}
