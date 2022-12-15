package bridge.controller;

import bridge.service.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeController {
    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeGame bridgeGame;

    public BridgeController(InputView inputView, OutputView outputView, BridgeGame bridgeGame) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridgeGame = bridgeGame;
    }

    public void makeBridge() {
        inputView.init();
        while (true) {
            try {
                bridgeGame.makeBridge(inputView.readBridgeSize());
                break;
            } catch (IllegalArgumentException i) {
                System.out.println(i.getMessage());
            }
        }
    }

    public void move() {
        while (true) {
            try {
                bridgeGame.move(inputView.readMoving());
                outputView.printMap(bridgeGame.getUserInputs(), bridgeGame.isGameOver());
                break;
            } catch (IllegalArgumentException i) {
                System.out.println(i.getMessage());
            }
        }
    }

    public boolean isWin() {
        return bridgeGame.isGameWin();
    }

    public boolean isGameOver() {
        return bridgeGame.isGameOver();
    }

    public boolean retry() {
        while (true) {
            try {
                return bridgeGame.retry(inputView.readRestartSelection());
            } catch (IllegalArgumentException i) {
                System.out.println(i.getMessage());
            }
        }
    }

    public void result() {
        outputView.printResult(
                bridgeGame.getCount(),
                bridgeGame.isGameOver(),
                bridgeGame.getUserInputs());
    }
}
