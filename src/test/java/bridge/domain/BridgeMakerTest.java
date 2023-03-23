package bridge.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.BridgeTestNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class BridgeMakerTest {

    @DisplayName("주어진 사이즈에 대한 다리를 생성하는지 확인")
    @Test
    void makeBridgeTest1() {
        //given
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

        //when
        List<String> bridge = bridgeMaker.makeBridge(3);

        //then
        assertEquals(bridge.size(), 3);
    }

    @DisplayName("0,1에대해 U,D로 올바르게 변환하여 다리를 생성하는지")
    @Test
    void makeBridgeTest2() {
        //given
        BridgeNumberGenerator bridgeNumberGenerator1 = new BridgeTestNumberGenerator(0);
        BridgeNumberGenerator bridgeNumberGenerator2 = new BridgeTestNumberGenerator(1);

        //when
        BridgeMaker upBridgeMaker = new BridgeMaker(bridgeNumberGenerator1);
        BridgeMaker downBridgeMaker = new BridgeMaker(bridgeNumberGenerator2);

        //then
            assertAll(
                ()-> assertThat(upBridgeMaker.makeBridge(3))
                        .isEqualTo(Arrays.asList("D","D","D")),
                ()-> assertThat(downBridgeMaker.makeBridge(3))
                        .isEqualTo(Arrays.asList("U","U","U"))
        );
    }
}
