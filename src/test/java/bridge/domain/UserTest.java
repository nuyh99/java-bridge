package bridge.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class UserTest {

    @ValueSource(strings = {"U", "D"})
    @ParameterizedTest
    void 이동할_칸_입력받기(String input) throws Exception{
        //given
        User user = new User();

        //when
        user.move(input);

        //then
    }

    @ValueSource(strings = {"Ud", "Q", "1", "faksljfle"})
    @ParameterizedTest
    void 잘못된_이동(String input) throws Exception{
        //given
        User user = new User();

        //when

        //then
        Assertions.assertThatThrownBy(() -> user.move(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}