package model.service.calculator;

import static model.domain.unit.PrizeUnit.*;
import static model.domain.unit.Unit.*;
import static model.service.LottoWinning.*;

public class CalculatorImpl implements Calculator {

    @Override
    public double percentCalculator(int inputMoney) {
        return Math.round(((double) getTotalPrize() / inputMoney) * PERCENT_UNIT.getValue() * 10) / 10.0;
    }

    private int getTotalPrize() {
        return FIRST.getCount() * FIRST_PRIZE.getPrize()
                + SECOND.getCount() * SECOND_PRIZE.getPrize()
                + THIRD.getCount() * THIRD_PRIZE.getPrize()
                + FOURTH.getCount() * FOURTH_PRIZE.getPrize()
                + FIFTH.getCount() * FIFTH_PRIZE.getPrize();
    }
}
