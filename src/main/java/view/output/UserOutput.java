package view.output;

import model.domain.Lotto;

import java.util.List;

public interface UserOutput {
    void printLotto(int count, List<List<Integer>> lottoNumbersList);

    void printResult(int[] matches, double percent);
}
