package bridge.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeTest {

    @ValueSource(strings = {"3", "5", "20"})
    @ParameterizedTest
    void 다리_길이_입력받기(String input) throws Exception{
        //given
        Bridge bridge = new Bridge();

        //when
        bridge.readBridgeLength(input);

        //then
    }
}