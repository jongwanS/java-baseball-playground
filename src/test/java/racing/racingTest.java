package racing;

import baseball.Balls;
import baseball.PlayResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 경험해야할 학습 목표
 TDD 기반으로 프로그래밍하는 경험
 메소드 분리 + 클래스를 분리하는 리팩토링 경험
 점진적으로 리팩토링하는 경험
 경험할 객체지향 생활 체조 원칙
 규칙 1: 한 메서드에 오직 한 단계의 들여쓰기만 한다.
 규칙 2: else 예약어를 쓰지 않는다.
 규칙 3: 모든 원시값과 문자열을 포장한다.
 규칙 5: 줄여쓰지 않는다(축약 금지).
 규칙 8: 일급 콜렉션을 쓴다.

 기능 요구사항
 각 자동차에 이름을 부여할 수 있다. 자동차 이름은 5자를 초과할 수 없다.
 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
 자동차 이름은 쉼표(,)를 기준으로 구분한다.
 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4이상일 경우이다.
 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한명 이상일 수 있다.


 ex)
 경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).
 pobi,crong,honux
 시도할 회수는 몇회인가요?
 5

 */
public class racingTest {

    @Test
    @DisplayName("자동차 이름은 5자를 초과할수 없다.")
    void carNameLengthValidation() {
        assertThat(RacingValidateUtilsTest.nameValidation("1234555")).isFalse();
        assertThat(RacingValidateUtilsTest.nameValidation("")).isFalse();
        assertThat(RacingValidateUtilsTest.nameValidation(null)).isFalse();
        assertThat(RacingValidateUtilsTest.nameValidation("1")).isTrue();
        assertThat(RacingValidateUtilsTest.nameValidation("자동차1")).isTrue();
    }

    /**
     * 자동차는 자동차 이름과 위치 정보를 가지는 Car 객체를 추가해 구현한다.
     */
    @Test
    void 자동차1개_실행() {
        Car car = new Car("자동차1", 0);
        car.play();
        car.printDistance(car);
    }

    @Test
    void 자동차2개_실행_승리자() {
        Car car1 = new Car("자동차1", 0);
        Car car2 = new Car("자동차2", 0);
        Cars cars = new Cars(Arrays.asList(car1,car2));
        for(Car car : cars.getCars()){
            car.play();
            car.printDistance(car);
        }
        cars.getWinners();
    }
    @Test
    void 자동차2개_실행_승리자2명() {
        Car car1 = new Car("자동차1", 1);
        Car car2 = new Car("자동차2", 1);
        Cars cars = new Cars(Arrays.asList(car1,car2));
        for(Car car : cars.getCars()){
            car.printDistance(car);
        }
        cars.getWinners();
    }
}
