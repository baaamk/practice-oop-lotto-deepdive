package model.service.validator;

import model.domain.exception.Error;

import java.util.List;

import static model.domain.exception.Error.DUPLICATED_BONUS_NUMBER;

public class ValidatorImpl implements Validator {

    public void validateBonusNumber(List<Integer> targetLotto, int bonusNumber) {
        if (targetLotto.contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATED_BONUS_NUMBER);
        }
    }

    public int validateNumber(String inputNumber) {
        try {
            return Integer.parseInt(inputNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Error.INVALID_NUMBER_FORMAT);
        }
    }
}
