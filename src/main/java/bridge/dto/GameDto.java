package bridge.dto;

import bridge.domain.BridgeGame;

import java.util.List;

public final class GameDto {

    private final BridgeGame bridgeGame;

    
    public GameDto(BridgeGame bridgeGame) {
        this.bridgeGame = bridgeGame;
    }

    public List<String> getMoveLogs() {
        return bridgeGame.getMoveLogs();
    }

    public int getGameTryCount() {
        return bridgeGame.getGameTryCount();
    }

    public boolean isSuccess() {
        return bridgeGame.isGameSuccess();
    }
}
