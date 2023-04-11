package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class Bridge {
    private List<String> structures;

    public Bridge() {
    }

    public void build(List<String> structure) {
        this.structures = structure;
    }

    public boolean isCorrect(int stage, String predict) {
        int latest = stage - 1;
        return structures.get(latest).equals(predict);
    }
}

