package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public final class BridgeGame {

    public final static String UP_SIDE = "U";
    public final static String DOWN_SIDE = "D";
    private static int gameTryCount;
    private final List<String> moveLogs;
    private final List<String> map;

    public BridgeGame(List<String> map) {
        this.map = map;
        moveLogs = new ArrayList<>();
    }

    static {
        gameTryCount = 1;
    }

    public boolean move(String direction) {
        int nextPosition = moveLogs.size();
        moveLogs.add(direction);
        return map.get(nextPosition).equals(direction);
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
}
