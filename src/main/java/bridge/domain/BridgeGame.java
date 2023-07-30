package bridge.domain;

import java.util.List;

public final class BridgeGame {
    private final BridgeMap bridgeMap;
    private static int gameTryCount;

    static {
        gameTryCount = 1;
    }

    public BridgeGame(BridgeMap bridgeMap) {
        this.bridgeMap = bridgeMap;
    }

    public boolean move(String direction) {
        return bridgeMap.isCorrectWay(direction);
    }

    public void retry() {
        gameTryCount++;
    }

    public int getGameTryCount() {
        return gameTryCount;
    }

    public boolean isGameSuccess(List<String> map, List<String> moveLogs) {
        return (moveLogs.size() == map.size())
                && (moveLogs.toString().equals(map.toString()));
    }
}
