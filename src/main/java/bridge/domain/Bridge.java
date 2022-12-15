package bridge.domain;

import bridge.exception.InputException;

import java.util.ArrayList;
import java.util.List;

public class Bridge {
    private final List<Integer> answer = new ArrayList<>();
    private int length;

    public int getLength() {
        return length;
    }

    public List<Integer> getAnswer() {
        return answer;
    }

    /**
     * 도메인 로직
     */
    public void readBridgeLength(String input) {
        int length = validateNumericValue(input);
        validateNumberRange(length);

        this.length = length;
    }

    public void makeBridge(int bridge) {
        answer.add(bridge);
    }


    private int validateNumericValue(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException n) {
            throw new IllegalArgumentException(InputException.NOT_A_NUMBER.getMessage());
        }
    }

    private void validateNumberRange(int number) {
        if(number<3 || 20<number)
            throw new IllegalArgumentException(InputException.INVALID_NUMBER_RANGE.getMessage());
    }
}
