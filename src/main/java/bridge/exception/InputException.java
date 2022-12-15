package bridge.exception;

public enum InputException {
    NOT_A_NUMBER("숫자를 입력해야 합니다."),
    INVALID_NUMBER_RANGE("3~20 범위의 숫자를 입력해야 합니다."),;

    private final String message;
    private final String prefix="[ERROR] ";

    InputException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return prefix+message;
    }
}