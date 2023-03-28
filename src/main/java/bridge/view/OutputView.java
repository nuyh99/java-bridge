package bridge.view;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    public static final String START_MESSEGE = "다리 건너기 게임을 시작합니다.";
    public static final String DOWN_INITIAL = "D";
    public static final String UP_INITIAL = "U";
    public static final String BLANK = " ";
    public static final String NONVALUE = "";
    public static final String PARTITION = "|";
    public static final String RIGHT_SIGN = "O";
    public static final String OPEN = "[";
    public static final String CLOSE = "]";
    public static final int BEGIN_INDEX = 2;
    public static final String FINAL_RESULT_MESSEGE = "\n최종 게임 결과";
    public static final String FINAL_SUCCESS_MESSEGE = "게임 성공 여부: 성공";
    public static final String FINAL_FAIL_MESSEGE = "게임 성공 여부: 실패";
    public static final String TOTAL_TRY_NUMBER_MESSEGE = "총 시도한 횟수: ";

    public static void printStartMessege() {
        System.out.println(START_MESSEGE);
    }

    public static void printMap(List<List<String>> result) {
        String upstr = result.get(0).stream()
                .collect(Collectors.joining());
        String downstr = result.get(1).stream()
                .collect(Collectors.joining());

        String UpSide = upstr.replace(DOWN_INITIAL, BLANK);
        UpSide = UpSide.replace(NONVALUE, PARTITION);
        UpSide = UpSide.replace(UP_INITIAL, RIGHT_SIGN);
        UpSide = UpSide.replace(NONVALUE, BLANK);


        String DownSide = downstr.replace(UP_INITIAL, BLANK);
        DownSide = DownSide.replace(NONVALUE, PARTITION);
        DownSide = DownSide.replace(DOWN_INITIAL, RIGHT_SIGN);
        DownSide = DownSide.replace(NONVALUE, BLANK);


        String A = OPEN + UpSide.substring(BEGIN_INDEX, UpSide.length() - BEGIN_INDEX) + CLOSE;
        String B = OPEN + DownSide.substring(BEGIN_INDEX, DownSide.length() - BEGIN_INDEX) + CLOSE;

        System.out.println(A + "\n" + B);
    }

    public static void printResult(List<List<String>> result, boolean success, int tryNumber) {
        System.out.println(FINAL_RESULT_MESSEGE);
        printMap(result);
        if (success) {
            System.out.println(FINAL_SUCCESS_MESSEGE);
        }
        if (!success) {
            System.out.println(FINAL_FAIL_MESSEGE);
        }
        System.out.println(TOTAL_TRY_NUMBER_MESSEGE + tryNumber);
    }
}
