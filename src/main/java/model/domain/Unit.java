package model.domain;

public enum Unit {
    FIRST_PRIZE(2000000000),
    SECOND_PRIZE(30000000),
    THIRD_PRIZE(1500000),
    FOURTH_PRIZE(50000),
    FIFTH_PRIZE(5000);

    private final int prize;

    Unit(int prize) {
        this.prize = prize;
    }

    public int getPrize() {
        return prize;
    }
}
