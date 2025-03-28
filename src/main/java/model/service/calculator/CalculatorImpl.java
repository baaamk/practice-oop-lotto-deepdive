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
        return Math.round(((double) getTotalPrize() / inputMoney) * PERCENT_UNIT.getValue() * 10) / 10.0;
    }

    private int getTotalPrize() {
        return lottoWinning.getFirst() * FIRST_PRIZE.getPrize()
                + lottoWinning.getSecond() * SECOND_PRIZE.getPrize()
                + lottoWinning.getThird() * THIRD_PRIZE.getPrize()
                + lottoWinning.getFourth() * FOURTH_PRIZE.getPrize()
                + lottoWinning.getFifth() * FIFTH_PRIZE.getPrize();
    }
}
