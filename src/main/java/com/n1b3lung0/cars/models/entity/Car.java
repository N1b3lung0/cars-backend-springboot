package com.n1b3lung0.cars.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "cars")
public class Car implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Size(min = 4, max = 12)
    @Column(nullable = false)
    private String name;

    @NotEmpty
    @Column(nullable = false) // unique = true
    private String brand;

    @NotNull
    @Column(name = "create_at")
    @Temporal(TemporalType.DATE)
    private Date createAt;

    private String photo;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id")
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    private Region region;

    public Long     getId()                     { return id; }
    public void     setId(Long id)              { this.id = id; }
    public String   getName()                   { return name; }
    public void     setName(String name)        { this.name = name; }
    public String   getBrand()                  { return brand; }
    public void     setBrand(String brand)      { this.brand = brand; }
    public Date     getCreateAt()               { return createAt; }
    public void     setCreateAt(Date createAt)  { this.createAt = createAt; }
    public String   getPhoto()                  { return photo; }
    public void     setPhoto(String photo)      { this.photo = photo; }
    public Region   getRegion()                 { return region; }
    public void     setRegion(Region region)    { this.region = region; }

    public Car UpdateCar(Car carToUpdate, Car car) {
        carToUpdate.setName(car.getName());
        carToUpdate.setBrand(car.getBrand());
        carToUpdate.setRegion(car.getRegion());
        return carToUpdate;
    }

    private static final long serialVersionUID = 1L;
}
