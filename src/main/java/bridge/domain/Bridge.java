package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class Bridge {
    private List<String> structure;
    private int size;

    public Bridge(int size) {
        this.size = size;
    }

    public void build(List<String> structure) {
        this.structure = structure;
    }

    public boolean isCorrect(int stage, String predict) {
        int index = stage - 1;
        return structure.get(index).equals(predict);
    }
}

