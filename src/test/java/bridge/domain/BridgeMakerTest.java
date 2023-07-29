package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;
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

    @DisplayName("다리 크기가 3이면 통과한다.")
    @Test
    void validateBridgeSize3() {
        Queue<Integer> expect = new LinkedList<>(List.of(1, 0, 1));
        assertThat(new BridgeMaker(() -> {
            return expect.poll().intValue();
        })
                .makeBridge(3)).isEqualTo(List.of("U", "D", "U"));
    }

    @DisplayName("다리 크기가 20이면 통과한다.")
    @Test
    void validateBridgeSize20() {
        Queue<Integer> expect = new LinkedList<>(List.of(
                1, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1));
        int index = 0;
        assertThat(new BridgeMaker(() -> {
            return expect.poll().intValue();
        })
                .makeBridge(20)).isEqualTo(List.of(
                "U", "D", "U", "U", "U", "U", "U", "D", "D", "D",
                "D", "D", "D", "U", "U", "U", "U", "D", "D", "U"));
    }
}