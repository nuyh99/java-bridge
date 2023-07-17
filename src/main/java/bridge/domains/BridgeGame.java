package bridge.domains;

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

    public void retry(String readCommand) {
        gameTryCount++;
        bridgeMap.reset();
    }

    public void quit() {

    }
}
