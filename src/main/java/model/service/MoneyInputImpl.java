package model.service;

public class MoneyInputImpl implements MoneyInput {

    private int count;

    @Override
    public int countLotto(int money) {
        if (money % 1000 !=0) {
            throw new IllegalStateException("message");
        }
        count = money/1000;
        return count;
    }

    @Override
    public int getCount() {
        return count;
    }
}
