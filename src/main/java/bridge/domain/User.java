package bridge.domain;

import bridge.exception.InputException;

import java.util.ArrayList;
import java.util.List;

public class User {
    private final List<Integer> inputs=new ArrayList<>();

    public void move(String input) {
        validateMove(input);
        inputs.add(Command.validateInput(input).getCommand());
    }

    private void validateMove(String input) {
        if(input.length()!=1)
            throw new IllegalArgumentException(InputException.INVALID_INPUT_LENGTH.getMessage());
    }
}
