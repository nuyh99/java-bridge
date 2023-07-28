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

    public Controller() {
        inputView = new InputView();
        outputView = new OutputView();

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
            outputView.printErrorMessage(e.getMessage());
            bridgeMap = makeBridge();
        }
        return bridgeMap;
    }

    private void play() {
        GameInformationDto bridgeMapDto = bridgeService.checkBridge();
        boolean isSuccess;
        do {
            isSuccess = bridgeService.step(inputView.readMoving());
            outputView.printMap(bridgeMapDto.getMoveLogs(), isSuccess);
        } while (isSuccess && !bridgeService.isClear());

        questionRestart(bridgeMapDto);
    }

    private void questionRestart(GameInformationDto gameInformationDto) {
        if (gameInformationDto.isSuccess()) {
            return;
        }

        String readCommand = inputView.readGameCommand();
    }

    private void finishGame(GameInformationDto gameInformationDto) {
        boolean isSuccess = gameInformationDto.isSuccess();
        List<String> moveLogs = gameInformationDto.getMoveLogs();
        outputView.printResult(moveLogs, isSuccess);
        outputView.printGameInformation(isSuccess, gameInformationDto.getGameTryCount());
    }
}
