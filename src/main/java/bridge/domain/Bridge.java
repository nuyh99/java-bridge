package bridge.domain;

import bridge.exception.InputException;

import java.util.ArrayList;
import java.util.List;

public class Bridge {
    private final List<Integer> answer = new ArrayList<>();

    public List<Integer> getAnswer() {
        return answer;
    }

    /**
     * 도메인 로직
     */
    public void validateBridgeLength(String input) {
        validateNumericValue(input);
        validateNumberRange(input);
    }

    public void makeBridge(int bridge) {
        answer.add(bridge);
    }


    private void validateNumericValue(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException n) {
            throw new IllegalArgumentException(InputException.NOT_A_NUMBER.getMessage());
        }
    }

    private void validateNumberRange(String input) {
        int number = Integer.parseInt(input);
        if(number<3 || 20<number)
            throw new IllegalArgumentException(InputException.INVALID_NUMBER_RANGE.getMessage());
    }
}
