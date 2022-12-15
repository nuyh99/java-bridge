package bridge.view;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<Integer> userInputs, boolean isGameOver) {
        List<List<String>> map = makeMap(userInputs, isGameOver);
        System.out.println(mapToString(map));
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(int count, boolean isGameOver, List<Integer> userInputs) {
        System.out.println("최종 게임 결과");
        printMap(userInputs, isGameOver);

        System.out.print("게임 성공 여부: ");
        if(!isGameOver)
            System.out.println("성공");
        if(isGameOver)
            System.out.println("실패");
        System.out.println("총 시도한 횟수: "+count);
    }

    private String mapToString(List<List<String>> map) {
        return map.stream()
                .map(o -> String.join(" | ", o))
                .map(o -> "[ " + o + " ]")
                .collect(Collectors.joining("\n"));
    }

    private List<String> initLine(int length) {
        List<String> line = new ArrayList<>();
        IntStream.range(0, length)
                .forEach(o->line.add(" "));

        return line;
    }

    private List<List<String>> makeMap(List<Integer> userInputs, boolean isGameOver) {
        List<String> upperLine = initLine(userInputs.size());
        List<String> lowerLine = initLine(userInputs.size());

        setElementToSuccess(userInputs, upperLine, lowerLine);
        if(isGameOver)
            setLastElementToFail(upperLine, lowerLine);

        return List.of(upperLine, lowerLine);
    }

    private void setElementToSuccess(List<Integer> userInputs, List<String> upper, List<String> lower) {
        for (int i = 0; i < userInputs.size(); i++) {
            if (userInputs.get(i) == 1) {
                upper.set(i, "O");
                continue;
            }

            lower.set(i, "O");
        }
    }

    private void setLastElementToFail(List<String> upperLine, List<String> lowerLine) {
        int index = upperLine.size()-1;

        if(upperLine.get(index).equals("O"))
            upperLine.set(index, "X");
        if(lowerLine.get(index).equals("O"))
            lowerLine.set(index, "X");
    }
}
