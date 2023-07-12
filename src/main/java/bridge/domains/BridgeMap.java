package bridge.domains;

import java.util.List;

public class BridgeMap {
    public final static String UP_SIDE = "U";
    public final static String DOWN_SIDE = "D";

    private final List<String> bridgeMade;

    public BridgeMap(List<String> bridgeMade){
        this.bridgeMade = bridgeMade;
    }

}
