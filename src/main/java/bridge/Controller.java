package bridge;

import bridge.domains.BridgeGame;
import bridge.domains.BridgeMaker;
import bridge.domains.BridgeMap;
import bridge.domains.BridgeRandomNumberGenerator;
import bridge.dto.GameInformationDto;
import bridge.services.BridgeService;
import bridge.views.InputView;
import bridge.views.OutputView;

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

    private BridgeMap createBridge() {
        try {
            int readSize = inputView.readBridgeSize();
            return new BridgeMap(new BridgeMaker(new BridgeRandomNumberGenerator()), readSize);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            createBridge();
        }
        return null;
    }

    private void play() {
        GameInformationDto bridgeMapDto = bridgeService.checkBridge();
        boolean isSuccess;
        do {
            isSuccess = bridgeService.step(inputView.readMoving());
            outputView.printMap(bridgeMapDto.getMoveHistory(), isSuccess);
        } while (isSuccess && !bridgeService.isClear());

        questionRestart(bridgeMapDto);
    }

    private void questionRestart(GameInformationDto gameInformationDto) {
        if (gameInformationDto.isSuccess()) return;

        String readCommand = inputView.readGameCommand();

        if (readCommand.equals(InputView.RESTART_COMMAND)) {
            bridgeService.restartGame(readCommand);
            play();
            return;
        }
    }

    private void finishGame(GameInformationDto gameInformationDto) {
        boolean isSuccess = gameInformationDto.isSuccess();
        List<String> moveHistory = gameInformationDto.getMoveHistory();
        outputView.printResult(moveHistory, isSuccess);
        outputView.printGameInformation(isSuccess, gameInformationDto.getGameTryCount());
    }
}
