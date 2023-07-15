package bridge.views;

public class InputChecker {

    private static final int SIZE_LOWER_BOUND = 3;
    private static final int SIZE_UPPER_BOUND = 20;


    static void validateNumeric(InputView inputView, String readSize) {
        try {
            Integer.parseInt(readSize);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해주세요");
        }
    }


//    static void validateDirection(String readDirection){
//        if()
//    }
}
