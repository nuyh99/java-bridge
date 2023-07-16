package bridge.views;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputCheckerTest {

    @DisplayName("입력에 정수 이외에 다른 것이 있다면 예외가 발생한다.")
    @Test
    void validateBridgeSizeByWord() {
        assertThatThrownBy(()
                -> InputChecker.validateNumeric(new InputView(), "ab"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력에 정수와 문자가 섞여 있으면 예외가 발생한다")
    @Test
    void validateBridgeSizeByWordAndNumber() {
        assertThatThrownBy(()
                -> InputChecker.validateNumeric(new InputView(), "a12b"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("방향 입력에서 DU를 동시에 입력하면 예외가 발생한다.")
    @Test
    void validateCommandByInputTogether() {
        assertThatThrownBy(()
                -> InputChecker.validateCommand(List.of("D", "U"), "DU"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("빈 칸을 입력하면 예외가 발생한다.")
    @Test
    void validateCommandByEmptySpace() {
        assertThatThrownBy(()
                -> InputChecker.validateCommand(List.of("D", "U"), " "))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("빈 칸을 입력하면 예외가 발생한다.")
    @Test
    void validateCommandByWrongCommand() {
        assertThatThrownBy(()
                -> InputChecker.validateCommand(List.of("D", "U"), "A"))
                .isInstanceOf(IllegalArgumentException.class);
    }


}