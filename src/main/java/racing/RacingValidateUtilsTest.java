package racing;

public class RacingValidateUtilsTest {

    public static final int CAR_NAME_MAX_LENGTH = 5;
    public static boolean nameValidation(String carName) {
        if(!isCarNameEmpty(carName)) return false;
        if(carName.length() > CAR_NAME_MAX_LENGTH) return false;
        return true;
    }

    public static boolean isCarNameEmpty(String carName){
        if(carName == null || carName.equals("")) return false;
        return true;
    }
}
