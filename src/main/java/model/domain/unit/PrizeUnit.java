package model.domain.unit;

public enum PrizeUnit {
    FIRST_PRIZE(2000000000),
    SECOND_PRIZE(30000000),
    THIRD_PRIZE(1500000),
    FOURTH_PRIZE(50000),
    FIFTH_PRIZE(5000);


    private final int prize;

    PrizeUnit(int prize) {
        this.prize = prize;
    }

    public int getPrize() {
        return prize;
    }
}
