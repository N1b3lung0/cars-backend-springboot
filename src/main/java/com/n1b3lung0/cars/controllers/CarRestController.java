package com.n1b3lung0.cars.controllers;

import com.n1b3lung0.cars.models.entity.Car;
import com.n1b3lung0.cars.models.services.ICarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
    public ResponseEntity<?> show(@PathVariable Long id) {
        Car car = null;
        Map<String, Object> response = new HashMap<>();
        try {
            car = carService.findById(id);
        } catch (DataAccessException e) {
            response.put("message", "Error trying to access to the DB.");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (car == null) {
            response.put("message", "The car ID: ".concat(id.toString().concat(" doesn't exist in the DB.")));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Car>(car, HttpStatus.OK);
    }

    @PostMapping(value={ "", "/" })
    public ResponseEntity<?> create(@Valid @RequestBody Car car, BindingResult result)
    {
        Car newCar = null;
        Map<String, Object> response = new HashMap<>();

        if (result.hasErrors()) {
            List<String> errors = result.getFieldErrors().stream()
                    .map( err -> err.getDefaultMessage()).collect(Collectors.toList());

            response.put("errors", errors);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }

        try {
            newCar = carService.save(car);
        } catch (DataAccessException e) {
            response.put("message", "Error trying to insert in the DB.");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("message", "The car has been created successfully.");
        response.put("car", newCar);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<Map<String, Object>> update(@Valid @RequestBody Car car, BindingResult result, @PathVariable Long id) {

        Car currentCar = carService.findById(id);
        Car updatedCar = null;
        Map<String, Object> response = new HashMap<>();

        if (result.hasErrors()) {
            List<String> errors = result.getFieldErrors().stream()
                    .map( err -> err.getDefaultMessage()).collect(Collectors.toList());

            response.put("errors", errors);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }

        if (currentCar == null) {
            response.put("message", "The car ID: ".concat(id.toString().concat(" doesn't exist in the DB.")));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        try {
            updatedCar = carService.save(car.UpdateCar(currentCar, car));
        } catch (DataAccessException e) {
            response.put("message", "Error trying to update in the DB.");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("message", "The car has been updated successfully.");
        response.put("car", updatedCar);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @DeleteMapping(value="{id}")
    public ResponseEntity<Map<String, Object>> delete(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        try {
            carService.delete(id);
        } catch (DataAccessException e) {
            response.put("message", "Error trying to delete the car in the DB.");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("message", "The car with ID " + id.toString() + " has been deleted successfully.");
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

}
