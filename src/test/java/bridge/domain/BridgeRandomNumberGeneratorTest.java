package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class BridgeRandomNumberGeneratorTest {

    @DisplayName("랜덤 난수 생성이 0 또는 1이어야 한다.")
    @Test
    void validateRandomGenerate() {
        assertThat(new BridgeRandomNumberGenerator().generate()).isIn(0, 1);
    }
}