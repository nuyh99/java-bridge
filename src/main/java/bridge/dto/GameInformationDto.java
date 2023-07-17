package bridge.dto;

import bridge.domains.BridgeGame;
import bridge.domains.BridgeMap;

import java.util.List;

public class GameInformationDto {

    private final BridgeMap bridgeMap;
    private final BridgeGame bridgeGame;

    public GameInformationDto(BridgeMap bridgeMap, BridgeGame bridgeGame) {
        this.bridgeMap = bridgeMap;
        this.bridgeGame = bridgeGame;

    }

    public List<String> getMoveHistory() {
        return bridgeMap.getMoveHistory();
    }

    public int getGameTryCount() {
        return bridgeGame.getGameTryCount();
    }

    public boolean isSuccess() {
        return bridgeGame.isGameSuccess();
    }


}
