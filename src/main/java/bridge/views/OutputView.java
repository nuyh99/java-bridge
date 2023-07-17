package bridge.views;

import java.util.List;
import java.util.stream.Collectors;

import static bridge.views.InputView.DOWN_COMMAND;
import static bridge.views.InputView.UP_COMMAND;

public final class OutputView {
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
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요.");
    }

    public void printMap(List<String> moveHistory, boolean isSuccess) {

        String result = draw(moveHistory, isSuccess);
        System.out.println(result);
    }

    private String draw(List<String> moveHistory, boolean isSuccess) {
        String upSideResult = drawSection(UP_COMMAND, moveHistory, isSuccess);
        String downSideResult = drawSection(DOWN_COMMAND, moveHistory, isSuccess);

        return (trimmedResult(upSideResult) + "\n" + trimmedResult(downSideResult));
    }

    private String trimmedResult(String result) {
        StringBuilder trimmedPrint = new StringBuilder(result);
        trimmedPrint.replace(0, 0, "[ ");
        trimmedPrint.append(" ]");

        return trimmedPrint.toString();
    }

    private String drawSection(String keyWord, List<String> moveHistory, boolean isSuccess) {
        List<String> printWords = moveHistory.stream()
                .map((e) -> getPrintWord(keyWord, e))
                .collect(Collectors.toList());

        convertLastWord(printWords, moveHistory.size() - 1, isSuccess);
        return String.join(" | ", printWords);
    }

    private void convertLastWord(List<String> printWords, int length, boolean isSuccess) {
        System.out.println(isSuccess);
        if (!isSuccess && printWords.get(length).equals("O")) {
            printWords.remove(length);
            printWords.add("X");
        }
    }

    private String getPrintWord(String keyWord, String e) {
        if (keyWord.equals(e)) {
            return "O";
        }
        return " ";
    }

    public void printResult(List<String> moveHistory, boolean isSuccess) {
        System.out.println();
        System.out.println("최종 게임 결과");
        printMap(moveHistory, isSuccess);
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
