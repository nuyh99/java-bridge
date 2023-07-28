package bridge.view;

import java.util.List;
import java.util.stream.Collectors;

import static bridge.view.InputView.DOWN_COMMAND;
import static bridge.view.InputView.UP_COMMAND;

public final class OutputView {

    private static final String SUCCESS_SIGN = "O";
    private static final String FAIL_SIGN = "X";
    private static final String BRIDGE_DELIMITER = " | ";
    private static final String RESULT_START_TAG = "[ ";
    private static final String RESULT_END_TAG = " ]";
    private static final String EMPTY_SIGN = " ";

    static {
        System.out.println("다리 건너기 게임을 시작합니다\n");
    }

    void printInputBridgeSizeText() {
        System.out.println("다리의 길이를 입력해주세요\n");
    }

    void printInputMoveDirection() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }

    void printRestartQuestion() {
        System.out.println("게임을 다시 시도할지 리여부를 입력해주세요.");
    }

    public void printMap(List<String> moveLogs, boolean isSuccess) {

        String result = draw(moveLogs, isSuccess);
        System.out.println(result);
    }

    private String draw(List<String> moveLogs, boolean isSuccess) {
        String upSideResult = drawSection(UP_COMMAND, moveLogs, isSuccess);
        String downSideResult = drawSection(DOWN_COMMAND, moveLogs, isSuccess);

        return (trimmedResult(upSideResult) + "\n" + trimmedResult(downSideResult));
    }

    private String trimmedResult(String result) {
        StringBuilder trimmedPrint = new StringBuilder(result);
        trimmedPrint.replace(0, 0, RESULT_START_TAG);
        trimmedPrint.append(RESULT_END_TAG);

        return trimmedPrint.toString();
    }

    private String drawSection(String keyWord, List<String> moveLogs, boolean isSuccess) {
        List<String> printWords = moveLogs.stream()
                .map((currentLog) -> getPrintWord(keyWord, currentLog))
                .collect(Collectors.toList());

        convertLastWord(printWords, isSuccess);
        return String.join(BRIDGE_DELIMITER, printWords);
    }

    private void convertLastWord(List<String> printWords, boolean isSuccess) {
        int lastIndex = printWords.size() - 1;
        if (!isSuccess && printWords.get(lastIndex).equals(SUCCESS_SIGN)) {
            printWords.set(lastIndex, FAIL_SIGN);
        }
    }

    private String getPrintWord(String keyWord, String currentLog) {
        if (keyWord.equals(currentLog)) {
            return SUCCESS_SIGN;
        }
        return EMPTY_SIGN;
    }

    public void printResult(List<String> moveLogs, boolean isSuccess) {
        System.out.println();
        System.out.println("최종 게임 결과");
        printMap(moveLogs, isSuccess);
    }

    public void printGameInformation(boolean isSuccess, int gameCount) {
        System.out.println();

        String gameSuccessText = "실패";
        if (isSuccess) {
            gameSuccessText = "성공";
        }

        System.out.println("게임 성공 여부: " + gameSuccessText);
        System.out.println("총 시도한 횟수: " + gameCount);
    }
}
