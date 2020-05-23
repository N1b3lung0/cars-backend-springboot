package com.n1b3lung0.cars.models.services;

import com.n1b3lung0.cars.models.dao.ICarDao;
import com.n1b3lung0.cars.models.entity.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ICarServiceImpl implements ICarService {

    @Autowired
    private ICarDao carDao;

    @Override
    @Transactional(readOnly = true)
    public List<Car> findAll() {
        return (List<Car>) carDao.findAll();
    }
}
