package web.service.serviceImpl;

import org.springframework.stereotype.Component;
import web.model.Car;
import web.service.CarService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarsServiceImpl implements CarService {
    private final List<Car> cars;

    public CarsServiceImpl() {
        cars = new ArrayList<>();
        cars.add(new Car(1, "BMW i5", 55000.0));
        cars.add(new Car(2, "Mercedes-Benz s350", 95000.0));
        cars.add(new Car(3, "Ford Mustang Shelby", 65000.0));
        cars.add(new Car(4, "Chevrolet Tahoe LT", 105000.0));
        cars.add(new Car(5, "Toyota Supra", 35000.0));
    }

    @Override
    public Car getCarById(int id) {
        return cars.stream().filter(car -> car.getId() == id).findAny().orElse(null);
    }

    @Override
    public List<Car> getCarsByCount(int count) {
        if (count == 0 || count >= 5) {
            return cars;
        }
        return cars.stream().limit(count).collect(Collectors.toList());
    }
}
