package bridge.services;

import bridge.domains.BridgeGame;
import bridge.domains.BridgeMap;
import bridge.dto.GameInformationDto;

public final class BridgeService {
    private final BridgeMap bridgeMap;
    private final BridgeGame bridgeGame;

    public BridgeService(BridgeMap bridgeMap, BridgeGame bridgeGame) {
        this.bridgeMap = bridgeMap;
        this.bridgeGame = bridgeGame;
    }

    public GameInformationDto checkBridge() {
        return new GameInformationDto(bridgeMap, bridgeGame);
    }

    public boolean step(String direction) {
        return bridgeGame.move(direction);
    }

    public boolean isClear() {
        return bridgeMap.isFinishBridge();
    }

    public void restartGame(String command) {
        bridgeGame.retry(command);
        bridgeMap.reset();
    }
}
