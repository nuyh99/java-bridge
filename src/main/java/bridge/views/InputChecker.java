package bridge.views;

import java.util.List;

public final class InputChecker {

    private static final int SIZE_LOWER_BOUND = 3;
    private static final int SIZE_UPPER_BOUND = 20;


    static void validateNumeric(InputView inputView, String readSize) {
        try {
            Integer.parseInt(readSize);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해주세요");
        }
    }

    static void validateCommand(List<String> commands, String readDirection) {
        int matchSize = (int) commands.stream()
                .filter(e -> e.contains(readDirection))
                .count();
        if (matchSize == 0) {
            throw new IllegalArgumentException("[ERROR] 올바르지 않은 입력입니다.");
        }
    }
}
