package com.example.springdocker.repository;

import com.example.springdocker.model.Car;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CarRepository extends MongoRepository<Car, String> {
    List<Car> findCarByCanDrive(boolean canDrive);
}