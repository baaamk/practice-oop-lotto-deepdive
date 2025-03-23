package model.service;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputNumberImpl implements InputNumber{
    private static final InputNumberImpl instance = new InputNumberImpl();

    private final List<Integer> targetNumbers = new ArrayList<>();

    public static InputNumberImpl getInstance() {
        return instance;
    }

    @Override
    public void inputNumber() {
        String[] targetNumber = readLine().split(",");
        for (String number : targetNumber) {
            targetNumbers.add(Integer.parseInt(number));
        }
    }

    public void inputBonusNumber() {
        String bonusNumber = readLine();
        targetNumbers.add(Integer.parseInt(bonusNumber));
    }

    public List<Integer> getTargetNumbers() {
        return targetNumbers;
    }
}
