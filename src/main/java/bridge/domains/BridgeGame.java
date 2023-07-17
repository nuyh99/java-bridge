package bridge.domains;

public final class BridgeGame {
    private final BridgeMap bridgeMap;
    private static int gameTryCount;
    static boolean gameSuccess;

    static {
        gameTryCount = 1;
    }

    public BridgeGame(BridgeMap bridgeMap) {
        this.bridgeMap = bridgeMap;
        gameSuccess = false;
    }

    public boolean move(String direction) {
        return bridgeMap.isCorrectWay(direction);
    }

    public void retry(String readCommand) {
        gameTryCount++;
    }

    public int getGameTryCount() {
        return gameTryCount;
    }

    public boolean isGameSuccess() {
        return gameSuccess;
    }
}
