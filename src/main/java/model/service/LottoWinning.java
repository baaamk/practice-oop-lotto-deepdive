package model.service;

public enum LottoWinning {
    FIFTH(0),
    FOURTH(0),
    THIRD(0),
    SECOND(0),
    FIRST(0);

    private int count;

    LottoWinning(int count) {
        this.count = 0;
    }

    public void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}

