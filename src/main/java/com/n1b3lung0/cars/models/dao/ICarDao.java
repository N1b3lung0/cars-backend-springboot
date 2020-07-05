package com.n1b3lung0.cars.models.dao;

import com.n1b3lung0.cars.models.entity.Car;
import com.n1b3lung0.cars.models.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ICarDao extends JpaRepository<Car, Long> {

    @Query("from Region")
    public List<Region> findAllRegions();
}
