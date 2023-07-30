package bridge.service;

import bridge.domain.BridgeGame;
import bridge.dto.GameInformationDto;

public final class BridgeService {
    private final BridgeGame bridgeGame;

    public BridgeService(BridgeGame bridgeGame) {
        this.bridgeGame = bridgeGame;
    }

    public GameInformationDto checkBridge() {
        return new GameInformationDto(bridgeGame);
    }

    public boolean step(String direction) {
        return bridgeGame.move(direction);
    }

    public boolean isClear() {
        return bridgeGame.isGameSuccess();
    }

    public void restartGame() {
        bridgeGame.reset();
    }
}
