package com.n1b3lung0.cars.models.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "cars")
@Data
public class Car implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String brand;

    @Column(name = "create_at")
    @Temporal(TemporalType.DATE)
    private Date createAt;

    private static final long serialVersionUID = 1L;
}
