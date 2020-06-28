package com.n1b3lung0.cars.controllers;

import com.n1b3lung0.cars.models.entity.Car;
import com.n1b3lung0.cars.models.services.ICarService;
import com.n1b3lung0.cars.models.services.IUploadFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.net.MalformedURLException;
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

    @Autowired
    private IUploadFileService uploadFileService;

    @GetMapping(value = { "", "/" })
    public List<Car> index() {
        return carService.findAll();
    }

    @GetMapping(value = { "/page/{page}" })
    public Page<Car> index(@PathVariable Integer page) {
        return carService.findAll(PageRequest.of(page, 3));
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

    @DeleteMapping(value="/{id}")
    public ResponseEntity<Map<String, Object>> delete(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        try {
            Car car = carService.findById(id);
            String previousFileName = car.getPhoto();
            uploadFileService.delete(previousFileName);
            carService.delete(id);
        } catch (DataAccessException e) {
            response.put("message", "Error trying to delete the car in the DB.");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("message", "The car with ID " + id.toString() + " has been deleted successfully.");
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

    @PostMapping(value="/upload")
    public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file, @RequestParam("id") Long id) {
        Map<String, Object> response = new HashMap<>();
        Car car = carService.findById(id);

        if (!file.isEmpty()) {
            String fileName = null;
            try {
                fileName = uploadFileService.copy(file);
            } catch (IOException e) {
                response.put("message", "Error trying to upload the image.");
                response.put("error", e.getMessage().concat(": ").concat(e.getCause().getMessage()));
                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }

            String previousFileName = car.getPhoto();

            uploadFileService.delete(previousFileName);
            car.setPhoto(fileName);
            carService.save(car);

            response.put("car", car);
            response.put("message", "Image " + fileName + " uploaded successfully");
        }
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @GetMapping(value="/uploads/img/{photoName:.+}")
    public ResponseEntity<Resource> getPhoto(@PathVariable String photoName) {

        Resource resource = null;

        try {
            resource = uploadFileService.load(photoName);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"");

        return new ResponseEntity<Resource>(resource, headers, HttpStatus.OK);
    }
}