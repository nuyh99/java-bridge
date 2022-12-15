package bridge.service;

import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Bridge;
import bridge.domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeGameTest {
    BridgeGame bridgeGame;
    Bridge bridge;
    User user;

    @BeforeEach
    void setup() {
        bridge = new Bridge();
        user = new User();
        bridgeGame=new BridgeGame(new BridgeRandomNumberGenerator(), bridge, user);
    }

    @Test
    void 다리_생성하기() throws Exception{
        //given
        bridge.readBridgeLength("10");

        //when
        bridgeGame.makeBridge();

        //then
        assertThat(bridge.getLength()).isEqualTo(10);
        assertThat(bridge.getAnswer().size()).isEqualTo(10);
        assertThat(bridge.getAnswer()).allMatch(o -> o == 0 || o == 1);
    }
}