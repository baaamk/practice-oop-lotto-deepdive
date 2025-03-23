package model.service;

import java.util.List;

public interface InputNumber {
    void inputNumber();

    List<Integer> getTargetNumbers();

    void inputBonusNumber();

    int getBonusNumber();
}
