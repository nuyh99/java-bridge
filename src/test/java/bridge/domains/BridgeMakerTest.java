package bridge.domains;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeMakerTest {

    @DisplayName("다리 크기가 3미만이면 예외를 발생시킨다.")
    @Test
    void validateBridgeToLowerBound() {
        Assertions.assertThatThrownBy(() ->
                        new BridgeMaker(new BridgeRandomNumberGenerator())
                                .makeBridge(2))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리 크기가 20초과면 예외를 발생시킨다.")
    @Test
    void validateBridgeToUpperBound() {
        Assertions.assertThatThrownBy(() ->
                        new BridgeMaker(new BridgeRandomNumberGenerator())
                                .makeBridge(21))
                .isInstanceOf(IllegalArgumentException.class);
    }
}