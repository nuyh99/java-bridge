package bridge.views;

public class InputChecker {

    private static final int SIZE_LOWER_BOUND = 3;
    private static final int SIZE_UPPER_BOUND = 20;

    static void validateBridgeSize(String readSize) {
        if (readSize.matches("[^0-9]+")) {
            throw new IllegalArgumentException("숫자만 입력해주세요");
        }

        validateSizeRange(readSize);
    }

    private static void validateSizeRange(String readSize) {
        int bridgeSize = Integer.parseInt(readSize);
        if (!(SIZE_LOWER_BOUND <= bridgeSize && bridgeSize <= SIZE_UPPER_BOUND)) {
            throw new IllegalArgumentException("3 ~ 20 사이의 정수를 입력해주세요");
        }
    }

//    static void validateDirection(String readDirection){
//        if()
//    }
}
