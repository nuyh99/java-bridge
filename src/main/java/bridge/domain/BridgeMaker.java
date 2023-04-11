package bridge.domain;

import bridge.BridgeNumberGenerator;
import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {

    public static final int DOWN = 0;
    private static final int MIN_BRIDGE_SIZE = 3;
    private static final int MAX_BRIDGE_SIZE = 20;
    private static final String OUT_OF_BIRDGE_SIZE_MESSEGE = "[ERROR] 다리 크기는 3에서 20사이의 수 입니다.";
    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();

        validate(size);

        while (bridge.size() < size) {
            int randomNumber = bridgeNumberGenerator.generate();
            bridge.add(convert(randomNumber));
        }

        return bridge;
    }

    private String convert(int number){
        String down = "D";
        String up = "U";
        if (number == DOWN){
            return down;
        }
        return up;
    }

    private void validate(int size) {
        if (size < MIN_BRIDGE_SIZE || size > MAX_BRIDGE_SIZE) {
            throw new IllegalArgumentException(OUT_OF_BIRDGE_SIZE_MESSEGE);
        }
    }
}
