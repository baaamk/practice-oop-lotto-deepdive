package model.domain;

import java.util.Collections;
import java.util.List;

import static model.domain.Error.*;
import static model.domain.Unit.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != UNIT_LOTTO_NUMBER.getValue()) {
            throw new IllegalArgumentException(INVALID_NUMBERS.getErrorMessage());
        }
    }

}
