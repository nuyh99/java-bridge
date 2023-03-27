package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class Player {
    List<String> history;
    int tryNumber;

    public Player() {
        this.tryNumber = 0;
    }

    public void makeHistory(String moving){
        this.history.add(moving);
    }
    public void updateTryNumber() {
        this.tryNumber += 1;
    }

    public void setTryNumber() {
        this.tryNumber = 0;
    }

    public int getTryNumber() {
        return tryNumber;
    }
}
