package model.service;

import java.util.Iterator;
import java.util.List;

public interface LottoMatcher {
    void match(List<Integer> targetNumbers, Iterator<Lotto> iterator, int bonusNumber);
}
