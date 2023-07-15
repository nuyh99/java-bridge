package bridge.dto;

public class GameInformationDtd {
    private final int gameTryCount;

    public GameInformationDtd(int gameTryCount) {
        this.gameTryCount = gameTryCount;
    }

    public int getGameTryCount() {
        return gameTryCount;
    }
}
