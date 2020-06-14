package com.n1b3lung0.cars.models.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "cars")
public class Car implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String brand;

    @Column(name = "create_at")
    @Temporal(TemporalType.DATE)
    private Date createAt;

    @PrePersist
    public void     prePersist()            { createAt = new Date(); }

    public Long     getId()                 { return id; }
    public void     setId(Long id)          { this.id = id; }
    public String   getName()               { return name; }
    public void     setName(String name)    { this.name = name; }
    public String   getBrand()              { return brand; }
    public void     setBrand(String brand)  { this.brand = brand; }
    public Date     getCreateAt()           { return createAt; }

    public Car UpdateCar(Car carToUpdate, Car car) {
        carToUpdate.setName(car.getName());
        carToUpdate.setBrand(car.getBrand());
        return carToUpdate;
    }

    private static final long serialVersionUID = 1L;
}
