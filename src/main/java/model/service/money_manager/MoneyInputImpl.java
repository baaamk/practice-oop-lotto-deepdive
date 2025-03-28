package model.service.money_manager;

import model.domain.Error;
import model.domain.Unit;

import static model.domain.Unit.*;

public class MoneyInputImpl implements MoneyInput {

    private int count;

    @Override
    public int countLotto(int money) {
        if (money % UNIT_MONEY.getValue() !=0) {
            throw new IllegalStateException(Error.INVALID_AMOUNT.getErrorMessage());
        }
        count = money/UNIT_MONEY.getValue();
        return count;
    }

    @Override
    public int getCount() {
        return count;
    }
}
