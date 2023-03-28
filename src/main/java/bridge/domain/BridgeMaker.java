package bridge.domain;

import bridge.BridgeNumberGenerator;
import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    public static final int DOWN = 0;
    private static final int MIN_BRIDGE_SIZE = 3;
    private static final int MAX_BRIDGE_SIZE = 20;
    private static final String ERROR_HEAD_MESSEGE = "[ERROR] ";
    private static final String OUT_OF_BIRDGE_SIZE_MESSEGE = "다리 크기는 3에서 20사이의 수 입니다.";
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

    public void validate(int size) {
        if (size < MIN_BRIDGE_SIZE || size > MAX_BRIDGE_SIZE) {
            throw new IllegalArgumentException(ERROR_HEAD_MESSEGE + OUT_OF_BIRDGE_SIZE_MESSEGE);
        }
    }
}
