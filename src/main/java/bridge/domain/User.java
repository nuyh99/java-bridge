package bridge.domain;

import bridge.exception.InputException;

import java.util.ArrayList;
import java.util.List;

public class User {
    private final List<Integer> inputs=new ArrayList<>();

    public List<Integer> getInputs() {
        return inputs;
    }

    /**
     * 도메인 로직
     */
    public void move(String input) {
        validateLength(input);
        inputs.add(Command.getMove(input).getCommand());
    }

    public boolean isAnswerCorrect(List<Integer> answer) {
        for(int i=0; i<inputs.size(); i++)
            if(!inputs.get(i).equals(answer.get(i)))
                return false;

        return true;
    }

    public boolean retry(String input) {
        validateLength(input);
        return Command.RESTART.equals(Command.getRestart(input));
    }

    public void init() {
        inputs.clear();
    }

    private void validateLength(String input) {
        if(input.length()!=1)
            throw new IllegalArgumentException(InputException.INVALID_INPUT_LENGTH.getMessage());
    }
}
