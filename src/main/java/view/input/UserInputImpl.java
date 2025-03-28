package view.input;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class UserInputImpl implements UserInput {

    public String inputMoney() {
        System.out.println("구입 금액을 입력하세요.");
        return readLine();
    }


    @Override
    public String inputNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return readLine();
    }

    @Override
    public String inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return readLine();
    }
}
