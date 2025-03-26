package model.service;

import model.repository.LottoWinning;
import model.repository.LottoWinningImpl;

public class CalculatorImpl implements Calculator {
    private final LottoWinning lottoWinning;

    public CalculatorImpl(LottoWinning lottoWinning) {
        this.lottoWinning = lottoWinning;
    }

    @Override
    public double percentCalculator(int inputMoney) {
        return Math.round((double) getTotalPrize() / inputMoney * 100 *10 /10.0);
    }

    private int getTotalPrize() {
        return lottoWinning.getFirst() * 2000000000
                + lottoWinning.getSecond() * 30000000
                + lottoWinning.getThird() * 1500000
                + lottoWinning.getFourth() * 50000
                + lottoWinning.getFifth() * 5000;
    }
}
