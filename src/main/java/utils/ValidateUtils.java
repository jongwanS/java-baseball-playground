package utils;

public class ValidateUtils {

    public static final int MIN_NO = 1;
    public static final int MAX_NO = 9;

    public static boolean validate(int i) {
        return i >= MIN_NO && i <= MAX_NO;
    }
}
