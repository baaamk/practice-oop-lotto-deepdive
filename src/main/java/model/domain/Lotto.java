package model.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import static model.domain.exception.Error.*;
import static model.domain.unit.Unit.*;

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
            throw new IllegalArgumentException(INVALID_LOTTO_COUNT.getErrorMessage());
        }
        if (!lottoNumberRange(numbers)) {
            throw new IllegalArgumentException(INVALID_RANGE.getErrorMessage());
        }
        if (hasDuplicates(numbers)) {
            throw new IllegalArgumentException(DUPLICATED_NUMBER.getErrorMessage());
        }
    }

    private static boolean lottoNumberRange(List<Integer> numbers) {
        return numbers.stream().allMatch(number -> number >= MIN_NUMBER.getValue() && number <= MAX_NUMBER.getValue());
    }

    private boolean hasDuplicates(List<Integer> numbers) {
        return new HashSet<>(numbers).size() < numbers.size();
    }
}
