package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;
import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {
    private final List<Car> cars;

    public CarService() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Mazda", "Black", 1975));
        cars.add(new Car("BMW", "Red", 2013));
        cars.add(new Car("Opel", "Blue", 2003));
        cars.add(new Car("Ford", "Blue", 2017));
        cars.add(new Car("VAZ", "White", 2006));
        this.cars = cars;
    }

    public List<Car> getCars(Integer count) {
        int numberCar = cars.size();
        if (count == null || count >= numberCar) {
            return cars;
        }
        if (count <= 0) {
            return List.of();
        }
        return new ArrayList<>(cars.subList(0, count));
    }
}