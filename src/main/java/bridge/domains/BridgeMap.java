package bridge.domains;

import java.util.ArrayList;
import java.util.List;

public final class BridgeMap {
    public final static String UP_SIDE = "U";
    public final static String DOWN_SIDE = "D";

    private final List<String> map;
    private final List<String> moveHistory;

    public BridgeMap(BridgeMaker bridgeMaker, int size) {

        map = bridgeMaker.makeBridge(size);
        moveHistory = new ArrayList<>();
    }

    public boolean isCorrectWay(String direction) {
        int nextPosition = moveHistory.size();

        recordMoveHistory(direction);

        return map.get(nextPosition).equals(direction);
    }

    private void recordMoveHistory(String direction) {
        moveHistory.add(direction);
    }

    public void reset() {
        moveHistory.clear();
    }
}
