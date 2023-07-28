package bridge.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputCheckerTest {

    @DisplayName("입력에 정수 이외에 다른 것이 있다면 예외가 발생한다.")
    @Test
    void validateBridgeSizeByWord() {
        assertThatThrownBy(()
                -> InputChecker.validateNumeric("ab"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자만 입력해주세요");
    }

    @DisplayName("입력에 정수와 문자가 섞여 있으면 예외가 발생한다")
    @Test
    void validateBridgeSizeByWordAndNumber() {
        assertThatThrownBy(()
                -> InputChecker.validateNumeric("a12b"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자만 입력해주세요");
    }

    @DisplayName("방향 입력에서 DU를 동시에 입력하면 예외가 발생한다.")
    @Test
    void validateCommandByInputTogetherOnInputDirection() {
        assertThatThrownBy(()
                -> InputChecker.validateCommand(List.of("D", "U"), "DU"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 올바르지 않은 입력입니다.\n" + List.of("D", "U") + " 중 하나를 입력해주세요.");


    }

    @DisplayName("방향 입력에서 빈 칸을 입력하면 예외가 발생한다.")
    @Test
    void validateCommandByEmptySpaceOnInputDirection() {
        assertThatThrownBy(()
                -> InputChecker.validateCommand(List.of("D", "U"), " "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 올바르지 않은 입력입니다.\n" + List.of("D", "U") + " 중 하나를 입력해주세요.");
    }

    @DisplayName("방향 입력에서 유효하지 않은 값을 입력하면 예외가 발생한다.")
    @Test
    void validateCommandByWrongCommandOnInputDirection() {
        assertThatThrownBy(()
                -> InputChecker.validateCommand(List.of("D", "U"), "A"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 올바르지 않은 입력입니다.\n" + List.of("D", "U") + " 중 하나를 입력해주세요.");
    }

    @DisplayName("게임 재시작 입력에서 DU를 동시에 입력하면 예외가 발생한다.")
    @Test
    void validateCommandByInputTogetherOnInputRestart() {
        assertThatThrownBy(()
                -> InputChecker.validateCommand(List.of("R", "Q"), "RQ"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 올바르지 않은 입력입니다.\n" + List.of("R", "Q") + " 중 하나를 입력해주세요.");


    }

    @DisplayName("게임 재시작 입력에서 빈 칸을 입력하면 예외가 발생한다.")
    @Test
    void validateCommandByEmptySpaceOnInputRestart() {
        assertThatThrownBy(()
                -> InputChecker.validateCommand(List.of("R", "Q"), " "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 올바르지 않은 입력입니다.\n" + List.of("R", "Q") + " 중 하나를 입력해주세요.");
    }

    @DisplayName("게임 재시작 입력에서 유효하지 않은 값을 입력하면 예외가 발생한다.")
    @Test
    void validateCommandByWrongCommandOnInputRestart() {
        assertThatThrownBy(()
                -> InputChecker.validateCommand(List.of("R", "Q"), "A"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 올바르지 않은 입력입니다.\n" + List.of("R", "Q") + " 중 하나를 입력해주세요.");
    }
}