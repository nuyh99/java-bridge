package bridge.service;

import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Bridge;
import bridge.domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

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

        //when
        bridgeGame.makeBridge("10");

        //then
        assertThat(bridge.getAnswer().size()).isEqualTo(10);
        assertThat(bridge.getAnswer()).allMatch(o -> o == 0 || o == 1);
    }

    @Test
    void 게임_승리() throws Exception{
        //given
        bridgeGame.makeBridge("10");
        List<Integer> answer = bridge.getAnswer();

        //when
        answer.forEach(o->user.getInputs().add(o));

        //then
        assertThat(bridgeGame.isGameOver()).isFalse();
        assertThat(bridgeGame.isGameWin()).isTrue();
    }

    @Test
    void 게임_패배() throws Exception{
        //given
        bridgeGame.makeBridge("10");
        List<Integer> answer = bridge.getAnswer();

        //when
        answer.forEach(o->user.getInputs().add(o));
        user.getInputs().set(9, 3);

        //then
        assertThat(bridgeGame.isGameOver()).isTrue();
        assertThat(bridgeGame.isGameWin()).isFalse();
    }
}