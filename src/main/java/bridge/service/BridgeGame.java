package bridge.service;

import bridge.BridgeNumberGenerator;
import bridge.domain.Bridge;
import bridge.domain.User;

import java.util.stream.IntStream;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final BridgeNumberGenerator bridgeNumberGenerator;
    private final Bridge bridge;
    private final User user;

    public BridgeGame(BridgeNumberGenerator bridgeNumberGenerator, Bridge bridge, User user) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
        this.bridge = bridge;
        this.user = user;
    }

    /**
     * 도메인 로직
     */
    public void makeBridge() {
        IntStream.range(0, bridge.getLength())
                .forEach(o -> bridge.makeBridge(bridgeNumberGenerator.generate()));
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String input) {
        user.move(input);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
