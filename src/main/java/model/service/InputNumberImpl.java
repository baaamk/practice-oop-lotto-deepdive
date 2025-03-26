package model.service;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputNumberImpl implements InputNumber{
    private static final InputNumberImpl instance = new InputNumberImpl();
    private final List<Integer> targetNumbers = new ArrayList<>();
    private int bonusNumber;

    public static InputNumberImpl getInstance() {
        return instance;
    }

    @Override
    public void inputNumber(List<Integer> targetNumber) {
        targetNumbers.addAll(targetNumber);
    }

    @Override
    public void inputBonusNumber(int inputBonusNumber) {
        bonusNumber = inputBonusNumber;
    }

    @Override
    public List<Integer> getTargetNumbers() {
        return targetNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
