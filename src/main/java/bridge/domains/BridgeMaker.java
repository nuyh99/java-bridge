package bridge.domains;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static bridge.domains.BridgeMap.*;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
final public class BridgeMaker {

    public static final int BRIDGE_LOWER_LENGTH = 3;
    public static final int BRIDGE_UPPER_LENGTH = 20;
    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        try {
            validateSize(size);
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            return null;
        }
        return Stream.generate(bridgeNumberGenerator::generate)
                .limit(size)
                .map(this::getBridgeKeyword)
                .collect(Collectors.toList());
    }

    private void validateSize(int size){
        if(!(BRIDGE_LOWER_LENGTH <= size && size <= BRIDGE_UPPER_LENGTH)){
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3 이상 20이하만 가능합니다.");
        }
    }
    private String getBridgeKeyword(int e){
        if(e == 1) return UP_SIDE;
        return DOWN_SIDE;
    }

