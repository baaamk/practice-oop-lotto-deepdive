package model.repository;

public class LottoWinningImpl implements LottoWinning{
    private static final LottoWinningImpl instance = new LottoWinningImpl();

    public static LottoWinningImpl getInstance() {
        return instance;
    }

    private int first;
    private int second;
    private int third;
    private int fourth;
    private int fifth;

    @Override
    public void addFirst() {
        first++;
    }

    @Override
    public void addSecond() {
        second++;
    }

    @Override
    public void addThird() {
        third++;
    }

    @Override
    public void addFourth() {
        fourth++;
    }

    @Override
    public void addFifth() {
        fifth++;
    }
}
