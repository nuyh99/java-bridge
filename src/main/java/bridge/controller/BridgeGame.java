package bridge.controller;

import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Bridge;
import bridge.domain.BridgeMaker;
import bridge.domain.Player;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class BridgeGame {

    private static final int START_STAGE = 1;
    private static final String FAIL_MARK = "X";
    private static final String UP_MARK = "U";
    private static final String DOWN_MARK = "D";
    private static final String END_MARK = "Q";
    private int stage = START_STAGE;
    private Player player = new Player();
    private Bridge bridge;
    private int lastStage;
    private boolean success;

    public void run() {
        GameStart();
        Gaming();
        OutputView.printResult(setResult(player.getRecord()), success,
            player.getTryNumber());
    }

    private void GameStart() {
        OutputView.printStartMessege();
        lastStage = InputView.readBridgeSize();
        buildBridge(lastStage);
        success = true;
    }

    private void Gaming() {
        while (success) {
            move(InputView.readMoving(), stage);
            if (isFinish()) {
                break;
            }
            if (!success) {
                success = true;
                retry();
            }
        }
    }

    private boolean isFinish() {
        if (success && stage > lastStage) {
            return true;
        }
        if (!success && InputView.readGameCommand().equals(END_MARK)) {
            return true;
        }
        return false;
    }

    private List<List<String>> setResult(List<String> playerRecord) {
        List<List<String>> result = new ArrayList<>();
        result.add(setBlock(playerRecord, UP_MARK));
        result.add(setBlock(playerRecord, DOWN_MARK));
        return result;
    }
    private List<String> setBlock(List<String> playerRecord,String position){
        List<String> block = new ArrayList<>(playerRecord);
        int latest = playerRecord.size()-1;
        if(!success && position.equals(playerRecord.get(latest))){
            block.set(playerRecord.size()-1, FAIL_MARK);
        }
        return block;
    }

    private void buildBridge(int size) {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        bridge = new Bridge();
        bridge.build(bridgeMaker.makeBridge(size));
    }

    public void move(String playerMoving, int stage) {
        this.stage = stage + 1;
        player.makeRecord(playerMoving);
        success = bridge.isCorrect(stage, playerMoving);
        OutputView.printMap(setResult(player.getRecord()));
    }

    public void retry() {
        player.updateTryNumber();
        player.resetRecord();
        this.stage = START_STAGE;
    }
}
