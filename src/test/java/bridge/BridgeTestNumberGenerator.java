package bridge;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.List;

public class BridgeTestNumberGenerator implements BridgeNumberGenerator {
    private List<Integer> position;

    public BridgeTestNumberGenerator(List<Integer> position){
        this.position = position;
    }
    @Override
    public int generate() {
        int target = position.get(0);
        position = position.subList(1,position.size());
        return target;
    }
}
