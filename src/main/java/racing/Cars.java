package racing;

import java.util.*;

import static java.util.stream.Collectors.*;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void getWinners() {


        List<Car> winners = cars.stream()
                .collect(groupingBy(Car::getPosition))
                .entrySet()
                .stream().max(Comparator.comparingInt(Map.Entry::getKey))
                .get()
                .getValue();

        for(Car car : winners){
            System.out.print(car.getCarName() + " ");
        }
    }
}
