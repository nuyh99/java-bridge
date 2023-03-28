package bridge.domain;

import bridge.view.OutputView;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@DisplayName("Player가")
public class PlayerTest {
    @DisplayName("입력한 이동을 저장하는지")
    @Test
    void PlayerTest1() {
        //given
        Player player = new Player();

        //when
        player.makeRecord("U");
        player.makeRecord("D");

        //then
        assertAll(
                ()-> assertThat(player.getRecord())
                        .isEqualTo(Arrays.asList("U","D"))
        );
    }

    @DisplayName("올바르지 않은 이동방향을 입력했을 때 예외를 발생시키는지")
    @Test
    void PlayerTest2() {
        //given
        Player player = new Player();

        //when
        player.makeRecord("U");

        //then
        Assertions.assertThatThrownBy(() -> player.makeRecord("K"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}

