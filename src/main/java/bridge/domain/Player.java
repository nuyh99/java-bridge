package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class Player {
    public static final String MOVABLE = "UD";

    private List<String> records = new ArrayList<>();
    int tryNumber;

    public Player() {
        this.tryNumber = 1;
    }

    public void makeRecord(String moving) {
        if (!MOVABLE.contains(moving)) {
            throw new IllegalArgumentException("[ERROR]");
        }
        this.records.add(moving);
    }

    public void updateTryNumber() {
        this.tryNumber += 1;
    }

    public void resetRecord() {
        this.records = new ArrayList<>();
    }

    public int getTryNumber() {
        return this.tryNumber;
    }

    public List<String> getRecord() {
        return this.records;
    }
}
