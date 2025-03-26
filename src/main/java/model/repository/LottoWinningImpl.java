package model.repository;

public class LottoWinningImpl implements LottoWinning{
    private static final LottoWinningImpl instance = new LottoWinningImpl();

    public static LottoWinningImpl getInstance() {
        return instance;
    }

    private final int[] matches = new int[5];

    public int[] getMatches() {
        return matches;
    }

    @Override
    public int addFirst() {
        return matches[4]++;
    }

    @Override
    public int addSecond() {
        return matches[3]++;
    }

    @Override
    public int addThird() {
        return matches[2]++;
    }

    @Override
    public int addFourth() {
       return matches[1]++;
    }

    @Override
    public int addFifth() {
        return matches[0]++;
    }

    public int getFirst() {
        return matches[4];
    }

    @Override
    public int getSecond() {
        return matches[3];
    }

    @Override
    public int getThird() {
        return matches[2];
    }

    @Override
    public int getFourth() {
        return matches[1];
    }

    @Override
    public int getFifth() {
        return matches[0];
    }
}
