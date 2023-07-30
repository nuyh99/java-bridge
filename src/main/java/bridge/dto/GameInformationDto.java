package bridge.dto;

import bridge.domain.BridgeGame;

import java.util.List;

public final class GameInformationDto {

    private final BridgeGame bridgeGame;

    public GameInformationDto(BridgeGame bridgeGame) {
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
