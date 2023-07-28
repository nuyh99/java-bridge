package bridge.dto;

import bridge.domain.BridgeGame;
import bridge.domain.BridgeMap;

import java.util.List;

public final class GameInformationDto {

    private final BridgeMap bridgeMap;
    private final BridgeGame bridgeGame;

    public GameInformationDto(BridgeMap bridgeMap, BridgeGame bridgeGame) {
        this.bridgeMap = bridgeMap;
        this.bridgeGame = bridgeGame;
    }

    public List<String> getMoveLogs() {
        return bridgeMap.getMoveLogs();
    }

    public int getGameTryCount() {
        return bridgeGame.getGameTryCount();
    }

    public boolean isSuccess() {
        return bridgeGame.isGameSuccess();
    }
}
