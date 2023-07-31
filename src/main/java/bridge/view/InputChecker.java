package bridge.view;

import java.util.List;

public final class InputChecker {

    private static final int SIZE_LOWER_BOUND = 3;
    private static final int SIZE_UPPER_BOUND = 20;

    static void validateNumeric(String readSize) {
        if (readSize == null)
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해주세요");

        try {
            Integer.parseInt(readSize);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해주세요");
        }
    }

    static void validateCommand(List<String> commands, String readDirection) {
        if (readDirection == null
                || commands.stream()
                .noneMatch(e -> e.equals(readDirection))) {
            throw new IllegalArgumentException("[ERROR] 올바르지 않은 입력입니다. " + commands + " 중 하나를 입력해주세요.");
        }
    }
}
