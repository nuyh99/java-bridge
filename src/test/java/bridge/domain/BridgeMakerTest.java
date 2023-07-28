package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BridgeMakerTest {

    final BridgeMaker bridgeMaker = new BridgeMaker(
            new BridgeRandomNumberGenerator());

    @DisplayName("다리 크기가 3미만이면 예외를 발생시킨다.")
    @Test
    void validateBridgeToLowerBound() {
        assertThatThrownBy(() -> bridgeMaker.makeBridge(2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 다리 길이는 3 이상 20 이하만 가능합니다.");
    }

    @DisplayName("다리 크기가 20초과면 예외를 발생시킨다.")
    @Test
    void validateBridgeToUpperBound() {
        assertThatThrownBy(() -> bridgeMaker.makeBridge(21))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 다리 길이는 3 이상 20 이하만 가능합니다.");
    }
}