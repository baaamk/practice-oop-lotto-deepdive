package model.service.matcher;

import model.repository.LottoWinning;
import model.domain.Lotto;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class LottoMatcherImpl implements LottoMatcher {

    private final LottoWinning lottoWinning;

    public LottoMatcherImpl(LottoWinning lottoWinning) {
        this.lottoWinning = lottoWinning;
    }

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
            lottoWinning.addFirst();
            return;
        }
        if (sameNumber == 5 && currentNumber.contains(bonusNumber)) {
            lottoWinning.addSecond();
            return;
        }
        if (sameNumber == 5) {
            lottoWinning.addThird();
            return;
        }
        if (sameNumber == 4) {
            lottoWinning.addFourth();
            return;
        }
        if (sameNumber == 3) {
            lottoWinning.addFifth();
        }
    }
}
