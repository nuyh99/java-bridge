package bridge;

import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.domain.BridgeMap;
import bridge.domain.BridgeRandomNumberGenerator;
import bridge.dto.GameInformationDto;
import bridge.service.BridgeService;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public final class Controller {
    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeService bridgeService;

    public Controller(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;

        BridgeMap bridgeMap = makeBridge();
        bridgeService = new BridgeService(bridgeMap, new BridgeGame(bridgeMap));
        play();
        finishGame(bridgeService.checkBridge());
    }

    private BridgeMap makeBridge() {
        BridgeMap bridgeMap;
        int readSize = inputView.readBridgeSize();

        try {
            bridgeMap = new BridgeMap(new BridgeMaker(new BridgeRandomNumberGenerator()), readSize);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
            bridgeMap = makeBridge();
        }
        return bridgeMap;
    }

    private void play() {
        GameInformationDto bridgeMapDto = bridgeService.checkBridge();
        boolean isSuccess = doStepBridge(bridgeMapDto);

        if (doRestart(bridgeMapDto)) {
            bridgeService.restartGame();
            play();
            return;
        }
    }

    private boolean doStepBridge(GameInformationDto bridgeMapDto) {
        boolean isSuccess;
        do {
            isSuccess = bridgeService.step(inputView.readMoving());
            outputView.printMap(bridgeMapDto.getMoveLogs(), isSuccess);
        } while (isSuccess && !bridgeService.isClear());

        return isSuccess;
    }

    private boolean doRestart(GameInformationDto gameInformationDto) {
        if (gameInformationDto.isSuccess()) {
            return false;
        }

        String readCommand = inputView.readGameCommand();
        return readCommand.equals(InputView.RESTART_COMMAND);
    }

    private void finishGame(GameInformationDto gameInformationDto) {
        boolean isSuccess = gameInformationDto.isSuccess();
        List<String> moveLogs = gameInformationDto.getMoveLogs();
        outputView.printResult(moveLogs, isSuccess);
        outputView.printGameInformation(isSuccess, gameInformationDto.getGameTryCount());
    }
}
