package model.service.money_manager;

import model.domain.Error;

public class MoneyInputImpl implements MoneyInput {

    private int count;

    @Override
    public int countLotto(int money) {
        if (money % 1000 !=0) {
            throw new IllegalStateException(Error.INVALID_AMOUNT.getErrorMessage());
        }
        count = money/1000;
        return count;
    }

    @Override
    public int getCount() {
        return count;
    }
}
