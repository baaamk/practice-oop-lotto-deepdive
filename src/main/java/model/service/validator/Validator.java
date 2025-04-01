package model.service.validator;

import java.util.List;

public interface Validator {
    void validateBonusNumber(List<Integer> targetLotto, int bonusNumber);
    int validateNumber(String inputNumber);
}
