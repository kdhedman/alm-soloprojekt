package com.example.springdocker.repository;

import com.example.springdocker.model.Food;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import static org.junit.jupiter.api.Assertions.*;

@DataMongoTest
class FoodRepositoryTest {

    @Autowired
    FoodRepository foodRepository;

    @Test
    void findFoodByCanICookItTest(){
        Food expectedFood = new Food();
        expectedFood.setName("Broccoli");
        expectedFood.setDelicious(true);
        expectedFood.setCanICookIt(true);
        foodRepository.save(expectedFood);

        Food expectedFood2 = new Food();
        expectedFood2.setName("Mjölk");
        expectedFood2.setDelicious(false);
        expectedFood2.setCanICookIt(false);
        foodRepository.save(expectedFood2);

        Food actualFood = foodRepository.findFoodByCanICookIt(true).get(0);
        boolean actual = actualFood.isCanICookIt();
        assertEquals(expectedFood.isCanICookIt(), actual);
        assertNotEquals(expectedFood2.isCanICookIt(), actual);

        actualFood = foodRepository.findFoodByCanICookIt(false).get(0);
        actual = actualFood.isCanICookIt();
        assertEquals(expectedFood2.isCanICookIt(), actual);
        assertNotEquals(expectedFood.isCanICookIt(), actual);
    }
}