package bridge;

import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {

    public static void main(String[] args) {
        new Controller(new InputView(), new OutputView());
    }
}
