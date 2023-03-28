package bridge.domain;

import bridge.BridgeNumberGenerator;
import bridge.BridgeTestNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class BridgeTest {
    @DisplayName("해당 스테이지의 정답과 예측의 일치여부를 맞게 반환하는지")
    @Test
    void makeBridgeTest2() {
        //given
        Bridge bridge = new Bridge(3);

        //when
        bridge.build(Arrays.asList("D","U","D"));

        //then
        assertAll(
                ()-> assertThat(bridge.isCorrect(1,"D"))
                        .isEqualTo(true),
                ()-> assertThat(bridge.isCorrect(2,"D"))
                        .isEqualTo(false)
        );
    }
}
