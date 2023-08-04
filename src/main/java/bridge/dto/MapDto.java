package bridge.dto;

import bridge.domain.BridgeGame;

import java.util.List;

public final class MapDto {
    private final BridgeGame bridgeGame;

    public MapDto(BridgeGame bridgeGame) {
        this.bridgeGame = bridgeGame;
    }

    public List<String> getMap() {
        return bridgeGame.getMap();
    }
}
