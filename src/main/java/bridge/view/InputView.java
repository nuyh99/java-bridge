package bridge.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    public static int readBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
        try{
            return Integer.parseInt(readLine());

        }catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 사이즈 입력 값은 숫자입니다.");
        }
    }

    public static String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        return readLine();
    }

    public static String readGameCommand() {
        System.out.println("게임을 다시 시도할 지 여부를 입력해주세요.(재시도: R, 종료: Q)");
        return readLine();
    }
}
