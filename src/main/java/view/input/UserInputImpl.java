package view.input;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class UserInputImpl implements UserInput {

    public int inputMoney() {
        System.out.println("구입 금액을 입력하세요.");
        return Integer.parseInt(readLine());
    }


    @Override
    public List<Integer> inputNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return Arrays.stream(readLine().split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    @Override
    public int inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Integer.parseInt(readLine());
    }
}
