package model.service.matcher;

import model.domain.Lotto;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import static model.service.LottoWinning.*;

public class LottoMatcherImpl implements LottoMatcher {

    @Override
    public void match(Lotto targetNumbers, Iterator<Lotto> eachLotto, int bonusNumber) {
        Set<Integer> targetSet = new HashSet<>(targetNumbers.getNumbers());
        while (eachLotto.hasNext()) {
            List<Integer> currentNumbers = eachLotto.next().getNumbers();
            int sameNumber = countMatchedNumbers(currentNumbers, targetSet);
            lottoRank(sameNumber, currentNumbers, bonusNumber);
        }
    }

    private int countMatchedNumbers(List<Integer> currentNumbers, Set<Integer> targetSet) {
        int count = 0;
        for (Integer number : currentNumbers) {
            if (targetSet.contains(number)) {
                count++;
            }
        }
        return count;
    }


    private void lottoRank(int sameNumber, List<Integer> currentNumber, int bonusNumber) {
        if (sameNumber == 6) {
            FIRST.increment();
            return;
        }
        if (sameNumber == 5 && currentNumber.contains(bonusNumber)) {
            SECOND.increment();
            return;
        }
        if (sameNumber == 5) {
            THIRD.increment();
            return;
        }
        if (sameNumber == 4) {
            FOURTH.increment();
            return;
        }
        if (sameNumber == 3) {
            FIFTH.increment();
        }
    }
}
