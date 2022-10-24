package baseball;

import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BallTest {

    private Ball com;
    @BeforeEach
    void setUp() {
        com = new Ball(1, 4);
    }

    /**
     nothing
     strike
     ball
     */
    @Test
    @DisplayName("야구게임에는 숫자 1~9만 들어와야 한다.")
    void 파라미터는1_9사이의_숫자(){
        assertThat(ValidateUtilsTest.validate(9)).isTrue();
        assertThat(ValidateUtilsTest.validate(1)).isTrue();
        assertThat(ValidateUtilsTest.validate(0)).isFalse();
        assertThat(ValidateUtilsTest.validate(10)).isFalse();
    }

    @Ignore
    @Test
    @DisplayName("스트라이크")
    void strike() {
        BallStatus status = com.play(new Ball(1, 4));
        assertThat(status).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    @DisplayName("볼")
    void ball() {
        BallStatus status = com.play(new Ball(2, 4));
        assertThat(status).isEqualTo(BallStatus.BALL);
    }

    @Test
    @DisplayName("nothing")
    void nothing() {
        BallStatus status = com.play(new Ball(2, 5));
        assertThat(status).isEqualTo(BallStatus.NOTHING);
    }
}
