package com.n1b3lung0.cars.models.services;

import com.n1b3lung0.cars.models.dao.ICarDao;
import com.n1b3lung0.cars.models.entity.Car;
import com.n1b3lung0.cars.models.entity.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ICarServiceImpl implements ICarService {

    @Autowired
    private ICarDao carDao;

    @Override
    @Transactional(readOnly = true)
    public List<Car> findAll() {
        return (List<Car>) carDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Car> findAll(Pageable pageable) { return carDao.findAll(pageable); }

    @Override
    @Transactional(readOnly = true)
    public Car findById(Long id) {
        return carDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Car save(Car car) {
        return carDao.save(car);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        carDao.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Region> findAllRegions() { return carDao.findAllRegions(); }
}
