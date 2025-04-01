package view.output;

import model.dto.LottoWinningDTO;

import java.util.List;

public interface UserOutput {
    void printLotto(int count, List<List<Integer>> lottoNumbersList);

    void printResult(List<LottoWinningDTO> results, double percent);
}
