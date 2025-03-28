package model.service.calculator;

import model.domain.Unit;
import model.repository.LottoWinning;

import static model.domain.PrizeUnit.*;
import static model.domain.Unit.*;

public class CalculatorImpl implements Calculator {
    private final LottoWinning lottoWinning;

    public CalculatorImpl(LottoWinning lottoWinning) {
        this.lottoWinning = lottoWinning;
    }

    @Override
    public double percentCalculator(int inputMoney) {
        return Math.round((double) getTotalPrize() / inputMoney * PERCENT_UNIT.getValue() *10 /10.0);
    }

    private int getTotalPrize() {
        return lottoWinning.getFirst() * FIRST_PRIZE.getPrize()
                + lottoWinning.getSecond() * FIRST_PRIZE.getPrize()
                + lottoWinning.getThird() * FIRST_PRIZE.getPrize()
                + lottoWinning.getFourth() * FIRST_PRIZE.getPrize()
                + lottoWinning.getFifth() * FIRST_PRIZE.getPrize();
    }
}
