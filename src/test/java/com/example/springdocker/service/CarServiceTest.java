package com.example.springdocker.service;

import com.example.springdocker.model.Car;
import com.example.springdocker.repository.CarRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CarServiceTest {

    CarService carService;

    @Mock
    CarRepository mockRepository;

    @BeforeEach
    public void init(){
        carService = new CarService(mockRepository);
    }

    @Test
    void getCars(){
        String expectedModel = "Fiesta";
        String expectedBrand = "Ford";
        Car mockCar = new Car("1", expectedModel, expectedBrand, true, true);

        when(mockRepository.findAll())
                .thenReturn(Arrays.asList(mockCar));

        List<Car> actual = carService.getCars();

        assertEquals(mockCar.getBrand(), actual.get(0).getBrand());
        assertEquals(expectedModel, actual.get(0).getModel());
        assertEquals(1, actual.size());

        verify(mockRepository).findAll();
    }

}