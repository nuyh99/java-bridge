package bridge.service;

import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.domain.BridgeRandomNumberGenerator;
import bridge.dto.GameDto;
import bridge.dto.MapDto;

import java.util.List;

public final class BridgeService {

    public MapDto makeBridgeMap(int mapSize) {
        List<String> map = new BridgeMaker(
                new BridgeRandomNumberGenerator()).makeBridge(mapSize);

        return new MapDto(new BridgeGame(map));
    }

    public GameDto stepNext(GameDto gameDto, MapDto mapDto, String direction) {
        BridgeGame bridgeGame =
                new BridgeGame(mapDto.getMap(), gameDto.getMoveLogs(), gameDto.getGameTryCount());

        if (bridgeGame.move(direction)) {
            return new GameDto(bridgeGame);
        }
        return new GameDto(new BridgeGame(mapDto.getMap()));
    }

    public boolean isMatch(MapDto mapDto, GameDto gameDto) {
        List<String> moveLogs = gameDto.getMoveLogs();
        int currentPoint = moveLogs.size() - 1;

        if (currentPoint < 0) return true;
        return moveLogs.get(currentPoint).equals(mapDto.getMap().get(currentPoint));
    }

    public GameDto resetGame(GameDto gameDto, MapDto mapDto) {
        BridgeGame bridgeGame =
                new BridgeGame(mapDto.getMap(), gameDto.getMoveLogs(), gameDto.getGameTryCount());

        bridgeGame.reset();

        return new GameDto(bridgeGame);
    }
}
