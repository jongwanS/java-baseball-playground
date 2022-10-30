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

        StringBuilder sb = new StringBuilder();
        for(Car car : winners){
            sb.append(car.getCarName());
            sb.append(",");
        }
        System.out.print(sb.toString() + " 가 최종 우승했습니다.");
    }

    public void carsPlay(){
        for(int i=0;i<cars.size();i++){
            Car car = cars.get(i);
            car.play();
            car.printDistance(car);
        }
    }
}
