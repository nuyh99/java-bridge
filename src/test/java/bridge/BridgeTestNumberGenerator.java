package bridge;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class BridgeTestNumberGenerator implements BridgeNumberGenerator {
    private int position;
    public BridgeTestNumberGenerator(int position){
        this.position = position;
    }
    @Override
    public int generate() {
        return position;
    }
}
