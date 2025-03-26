package model.service;

import java.util.List;

public interface InputNumber {
    public void inputNumber(List<Integer> targetNumber);

    List<Integer> getTargetNumbers();
    void inputBonusNumber(int inputBonusNumber);
    int getBonusNumber();

}
