package bridge;

import bridge.domain.BridgeGame;
import bridge.dto.GameDto;
import bridge.dto.MapDto;
import bridge.service.BridgeService;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public final class Controller {
    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeService bridgeService;

    public Controller(InputView inputView, OutputView outputView, BridgeService bridgeService) {

        this.inputView = inputView;
        this.outputView = outputView;
        this.bridgeService = bridgeService;

        init();
    }

    private void init() {
        int readSize = inputView.readBridgeSize();

        List<String> map = bridgeService.makeBridgeMap(readSize).getMap();
        BridgeGame bridgeGame = new BridgeGame(map);
        run(new GameDto(bridgeGame), new MapDto(bridgeGame));
    }

    private void run(GameDto gameDto, MapDto mapDto) {
        play(gameDto, mapDto);

        if (doRestart(gameDto)) {
            gameDto = bridgeService.resetGame(gameDto, mapDto);
            run(gameDto, mapDto);
            return;
        }
        finish(gameDto);
    }

    private void play(GameDto gameDto, MapDto mapDto) {
        String readMoving;

        while (canMove(gameDto, mapDto)) {
            readMoving = inputView.readMoving();
            gameDto = bridgeService.stepNext(gameDto, mapDto, readMoving);

            outputView.printMap(gameDto.getMoveLogs(), isMatched(gameDto, mapDto));
        }
    }

    private boolean canMove(GameDto gameDto, MapDto mapDto) {
        boolean isMatched = bridgeService.isMatch(mapDto, gameDto);
        boolean isReached = mapDto.getMap().size() <= gameDto.getMoveLogs().size();

        return (isMatched && !isReached);
    }

    private boolean isMatched(GameDto gameDto, MapDto mapDto) {
        List<String> moveLogs = gameDto.getMoveLogs();
        List<String> map = mapDto.getMap();
        int lastIndex = moveLogs.size() - 1;
        return moveLogs.get(lastIndex).equals(map.get(lastIndex));
    }

    private boolean doRestart(GameDto gameDto) {
        if (gameDto.isSuccess()) {
            return false;
        }
        String readCommand = inputView.readGameCommand();
        return readCommand.equals(InputView.RESTART_COMMAND);
    }

    private void finish(GameDto gameDto) {
        boolean isSuccess = gameDto.isSuccess();
        List<String> moveLogs = gameDto.getMoveLogs();

        outputView.printResult(moveLogs, isSuccess);
        outputView.printGameInformation(isSuccess, gameDto.getGameTryCount());
    }
}
