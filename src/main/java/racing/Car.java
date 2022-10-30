package racing;

import java.util.Random;

public class Car {

    private final String carName;
    private int position;

    public Car(String carName, int position) {
        this.carName = carName;
        this.position = position;
    }
    public int getPosition() {
        return this.position;
    }
    public String getCarName() {
        return this.carName;
    }

    public void play() {
        this.position+=new NumberGenerator().getRandomNum();
    }

    public void printDistance(Car car) {
        System.out.print(car.getCarName() + " : ");
        for(int i=0;i<this.position;i++){
            System.out.print("-");
        }
        System.out.println("");
    }

}
