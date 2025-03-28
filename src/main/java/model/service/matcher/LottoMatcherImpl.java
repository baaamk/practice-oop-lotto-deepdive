package model.service.matcher;

import model.repository.LottoWinning;
import model.domain.Lotto;

import java.util.Iterator;
import java.util.List;

public class LottoMatcherImpl implements LottoMatcher {

    private final LottoWinning lottoWinning;

    public LottoMatcherImpl(LottoWinning lottoWinning) {
        this.lottoWinning = lottoWinning;
    }

    @Override
    public void match(Lotto targetNumbers, Iterator<Lotto> eachLotto, int bonusNumber) {

        while (eachLotto.hasNext()) {
            List<Integer> currentNumber = eachLotto.next().getNumbers();
            int sameNumber = 0;
            for (Integer eachNumber : currentNumber) {
                if (targetNumbers.getNumbers().contains(eachNumber)) {
                    sameNumber++;
                }
            }
            lottoRank(sameNumber, currentNumber, bonusNumber);
        }
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
