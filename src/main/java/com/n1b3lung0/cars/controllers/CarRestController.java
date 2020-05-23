package com.n1b3lung0.cars.controllers;

import com.n1b3lung0.cars.models.entity.Car;
import com.n1b3lung0.cars.models.services.ICarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
