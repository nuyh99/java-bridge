package bridge.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Player {
    public static final String MOVABLE = "UD";
    private List<String> record;
    int tryNumber;

    public Player() {
        this.tryNumber = 0;
    }

    public void makeRecord(String moving) {
        if(!MOVABLE.contains(moving)){
            throw new IllegalArgumentException("[Error]");
        }
        this.record.add(moving);
    }

    public void updateTryNumber() {
        this.tryNumber += 1;
    }

    public void resetRecord() {
        this.record = Arrays.asList();
    }

    public int getTryNumber() {
        return tryNumber;
    }

    public List<String> getRecord() {
        return record;
    }

}
