package bridge.service;

import bridge.BridgeMaker;
import bridge.domain.Bridge;
import bridge.domain.Command;
import bridge.domain.User;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final BridgeMaker bridgeMaker;
    private final Bridge bridge;
    private final User user;
    private int count=1;

    public BridgeGame(BridgeMaker bridgeMaker, Bridge bridge, User user) {
        this.bridgeMaker = bridgeMaker;
        this.bridge = bridge;
        this.user = user;
    }

    /**
     * 도메인 로직
     */
    public void makeBridge(String input) {
        bridge.validateBridgeLength(input);
        List<String> bridge = bridgeMaker.makeBridge(Integer.parseInt(input));

        bridge.stream()
                .map(o->Command.getMove(o).getCommand())
                .forEach(this.bridge::makeBridge);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String input) {
        user.move(input);
    }

    public boolean isGameOver() {
        return !user.isAnswerCorrect(bridge.getAnswer());
    }

    public boolean isGameWin() {
        return !isGameOver() &&
                user.getInputs().size() == bridge.getAnswer().size();
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String input) {
        if(user.retry(input)){
            init();
            return true;
        }

        return false;
    }

    public int getCount() {
        return count;
    }

    public List<Integer> getUserInputs() {
        return user.getInputs();
    }

    private void init() {
        user.init();
        count++;
    }
}
