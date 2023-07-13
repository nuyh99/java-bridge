package bridge.domains;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeMakerTest {

    @DisplayName("다리 크기가 3미만이면 NULL을 반환한다")
    @Test
    void makeBridgeToLowerBound() {
        Assertions.assertThat(new BridgeMaker(new BridgeRandomNumberGenerator())
                .makeBridge(2)).isEqualTo(null);
    }

    @DisplayName("다리 크기가 20초과면 NULL을 반환한다.")
    @Test
    void makeBridgeToUpperBound() {
        Assertions.assertThat(new BridgeMaker(new BridgeRandomNumberGenerator())
                .makeBridge(21)).isEqualTo(null);
    }
}