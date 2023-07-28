package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public final class BridgeMap {
    public final static String UP_SIDE = "U";
    public final static String DOWN_SIDE = "D";

    private final List<String> map;
    private final List<String> moveLogs;

    public BridgeMap(BridgeMaker bridgeMaker, int size) {

        map = bridgeMaker.makeBridge(size);
        moveLogs = new ArrayList<>();
    }

    boolean isCorrectWay(String direction) {
        int nextPosition = moveLogs.size();
        moveLogs.add(direction);
        return map.get(nextPosition).equals(direction);
    }

    public boolean isFinishBridge() {
        return BridgeGame.gameSuccess =
                (moveLogs.size() == map.size()) &&
                        (moveLogs.toString().equals(map.toString()));
    }

    public void reset() {
        moveLogs.clear();
    }

    public List<String> getMoveLogs() {
        return moveLogs;
    }
}
