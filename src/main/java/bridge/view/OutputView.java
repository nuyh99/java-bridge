package bridge.view;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static String printMap(List<String> downBlock, List<String> upBlock){
        String upstr = upBlock.stream()
                .collect(Collectors.joining());
        String downstr = downBlock.stream()
                .collect(Collectors.joining());

        String UpSide = upstr.replace("D"," ");
        UpSide = UpSide.replace("","|");
        UpSide = UpSide.replace("U","O");

        String DownSide = downstr.replace("U"," ");
        DownSide = DownSide.replace("","|");
        DownSide = DownSide.replace("D","O");

        String A = "["+UpSide.substring(1,UpSide.length()-1)+"]";
        String B = "["+DownSide.substring(1,DownSide.length()-1)+"]";

        return A+"\n"+B;
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}
