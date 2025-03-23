package model.service;

import model.repository.LottoRepository;
import model.repository.LottoRepositoryImpl;
import model.repository.LottoWinning;

import java.util.Iterator;
import java.util.List;

public class LottoMatcherImpl implements LottoMatcher {

    private final LottoRepository lottoRepository;
    private final InputNumber inputNumber;
    private final LottoWinning lottoWinning;

    public LottoMatcherImpl(LottoWinning lottoWinning) {
        this.inputNumber = InputNumberImpl.getInstance();
        this.lottoWinning = lottoWinning;
        this.lottoRepository = LottoRepositoryImpl.getInstance();
    }

    @Override
    //나중에 ENUM으로 바꾸기
    public void match() {
        List<Integer> targetNumbers = inputNumber.getTargetNumbers();
        Iterator<Lotto> eachLotto = lottoRepository.getLotto().iterator();
        List<Integer> currentNumber = eachLotto.next().getNumbers();

        while (eachLotto.hasNext()) {
            int sameNumber = 0;
            if (!targetNumbers.containsAll(currentNumber)) {
                continue;
            }
            for (Integer eachNumber : currentNumber) {
                if (targetNumbers.contains(eachNumber)) {
                    sameNumber++;
                }
            }
            lottoRank(sameNumber, currentNumber);
        }
    }

    private void lottoRank(int sameNumber, List<Integer> currentNumber) {
        if (sameNumber == 6) {
            lottoWinning.addFirst();
            return;
        }
        if (sameNumber == 5 && currentNumber.contains(inputNumber.getBonusNumber())) {
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
