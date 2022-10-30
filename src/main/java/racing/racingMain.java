package racing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class racingMain {

    public static void main(String[] args) {
        /**
         경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).
         pobi,crong,honux
         시도할 회수는 몇회인가요?
         5
         */
        Scanner sc = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분");
        String carsStr = sc.next();
        String[] carsName = carsStr.split(",");
        System.out.println("시도할 회수는 몇회인가요?");
        int tryCount = sc.nextInt();

        ArrayList<Car> carList = new ArrayList<>();
        for(int i=0;i<carsName.length;i++){
            carList.add(new Car(carsName[i], 0));
        }

        Cars cars = new Cars(carList);

        for(int i=0;i<tryCount;i++){
            cars.carsPlay();
            System.out.println();
        }

        cars.getWinners();
    }
}
