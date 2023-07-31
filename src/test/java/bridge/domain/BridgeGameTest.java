package bridge.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class BridgeGameTest {
    private final List<String> TEST_MAP = List.of("U", "D", "D", "U", "D");

    private BridgeGame setTest(List<String> moveLogs) {
        BridgeGame bridgeGame = new BridgeGame(TEST_MAP);
        bridgeGame.getMoveLogs().addAll(moveLogs);
        return bridgeGame;
    }

    @DisplayName("방향에 맞는 결과가 나오면 통과한다.")
    @Test
    void testCorrectMoveResult() {
        BridgeGame bridgeGame = setTest(List.of("U,D"));

        List<Boolean> testResult = Stream.generate((()
                        -> bridgeGame.move("D")))
                .limit(2)
                .collect(Collectors.toList());

        Assertions.assertThat(testResult).isEqualTo(List.of(true, false));
    }

    @DisplayName("moveLogs와 map과 길이가 다르면 False를 반환")
    @Test
    void testWrongLength() {
        BridgeGame bridgeGame = setTest(List.of("U", "D", "U"));

        Assertions.assertThat(bridgeGame.isGameSuccess()).isFalse();
    }

    @DisplayName("moveLogs와 map과 문자가 다르면 False를 반환")
    @Test
    void testWrongWord() {
        BridgeGame bridgeGame = setTest(List.of("U", "D", "U", "D", "D"));

        Assertions.assertThat(bridgeGame.isGameSuccess()).isFalse();
    }

    @DisplayName("moveLogs와 map과 문자가 같으면 true 반환")
    @Test
    void getGameTryCount() {
        BridgeGame bridgeGame = setTest(List.of("U", "D", "D", "U", "D"));

        Assertions.assertThat(bridgeGame.isGameSuccess()).isTrue();
    }
}