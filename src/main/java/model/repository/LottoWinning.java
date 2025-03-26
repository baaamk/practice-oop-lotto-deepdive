package model.repository;

public interface LottoWinning {
    int addFirst();
    int addSecond();
    int addThird();
    int addFourth();
    int addFifth();
    int getFirst();
    int getSecond();
    int getThird();
    int getFourth();
    int getFifth();
    int[] getMatches();
}
