package com.example.springdocker;

public class MyMatchCalc {
    public int add(int a, int b){
        return a+b;
    }

    public int multiply(int a, int b){
        return a*b;
    }

    public double divide(int a, int b){
        if(b == 0) throw new IllegalArgumentException("Can not divide by zero.");
        return a/b;
    }
}
