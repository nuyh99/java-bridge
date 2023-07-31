package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public final class BridgeGame {
    public final static String UP_SIDE = "U";
    public final static String DOWN_SIDE = "D";

    private int gameTryCount;
    private final List<String> moveLogs;
    private final List<String> map;

    public BridgeGame(List<String> map) {
        this.map = map;
        moveLogs = new ArrayList<>();
        gameTryCount = 1;
    }

    public BridgeGame(List<String> map, List<String> moveLogs, int gameTryCount) {
        this.map = map;
        this.moveLogs = moveLogs;
        this.gameTryCount = gameTryCount;
    }

    public boolean move(String direction) {
        if (moveLogs.size() >= map.size()) {
            return false;
        }
        moveLogs.add(direction);
        return true;
    }

    public void reset() {
        gameTryCount++;
        moveLogs.clear();
    }

    public boolean isGameSuccess() {
        return (moveLogs.size() == map.size())
                && (moveLogs.toString().equals(map.toString()));
    }

    public int getGameTryCount() {
        return gameTryCount;
    }

    public List<String> getMoveLogs() {
        return moveLogs;
    }

    public List<String> getMap() {
        return map;
    }
}
