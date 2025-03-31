package model.service.money_manager;

import model.domain.exception.Error;

import static model.domain.exception.Error.*;
import static model.domain.unit.Unit.*;

public class MoneyInputImpl implements MoneyInput {

    private int count;

    @Override
    public int countLotto(int money) {
        if (money <= 0) {
            throw new IllegalArgumentException(INVALID_PURCHASE_AMOUNT);
        }
        if (money % UNIT_MONEY.getValue() !=0) {
            throw new IllegalArgumentException(INVALID_AMOUNT);
        }
        count = money/UNIT_MONEY.getValue();
        return count;
    }

    @Override
    public int getCount() {
        return count;
    }
}
