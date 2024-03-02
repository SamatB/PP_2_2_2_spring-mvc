package web.service;

import web.model.Car;

import java.util.List;

public interface  CarService {

    Car getCarById(int id);

    List<Car> getCarsByCount(int count);
}
