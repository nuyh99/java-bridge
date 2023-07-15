package bridge.views;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputCheckerTest {

    @DisplayName("입력에 정수 이외에 다른 것이 있다면 false를 반환한다.")
    @Test
    void validateBridgeSizeByWord() {
        assertThatThrownBy(()
                -> InputChecker.validateNumeric(new InputView(), "ab"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력에 정수와 문자가 섞여 있으면 false를 반환한다.")
    @Test
    void validateBridgeSizeByWordAndNumber() {
        assertThatThrownBy(()
                -> InputChecker.validateNumeric(new InputView(), "a12b"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}