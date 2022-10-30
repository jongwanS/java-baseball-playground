package racing;

import java.util.Random;

public class NumberGenerator {
    private int resultNum = 0;
    private final int MIN_NO = 0;
    private final int MAX_NO = 9;

    private final Random random = new Random();
    public NumberGenerator() {
        this.resultNum = random.nextInt(MIN_NO + MAX_NO) + MIN_NO;
    }

    public int getRandomNum(){
        return this.resultNum;
    }
}
