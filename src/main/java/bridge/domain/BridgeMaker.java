package bridge.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static bridge.domain.BridgeGame.DOWN_SIDE;
import static bridge.domain.BridgeGame.UP_SIDE;

public final class BridgeMaker {
    private static final int BRIDGE_LOWER_LENGTH = 3;
    private static final int BRIDGE_UPPER_LENGTH = 20;

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        validateSize(size);

        return Stream.generate(bridgeNumberGenerator::generate)
                .limit(size)
                .map(this::getBridgeKeyword)
                .collect(Collectors.toList());
    }

    private void validateSize(int size) {
        if (!(BRIDGE_LOWER_LENGTH <= size && size <= BRIDGE_UPPER_LENGTH)) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3 이상 20 이하만 가능합니다.");
        }
    }

    private String getBridgeKeyword(int keyNumber) {
        if (keyNumber == 1) return UP_SIDE;
        return DOWN_SIDE;
    }
}

