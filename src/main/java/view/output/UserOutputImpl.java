package view.output;

import model.domain.Lotto;
import model.dto.LottoWinningDTO;

import java.util.Collections;
import java.util.List;

public class UserOutputImpl implements UserOutput {
    @Override
    public void printLotto(int count, List<List<Integer>> lottoNumbersList) {
        System.out.println(count +"개를 구매했습니다.");
        for (List<Integer> lotto : lottoNumbersList) {
            System.out.println(lotto);
        }
    }

    @Override
    public void printResult(List<LottoWinningDTO> results, double percent) {
        for (LottoWinningDTO result : results) {
            System.out.println(result.getDescription() + " - " + result.getCount() + "개");
        }
        System.out.println("총 수익률은 " + percent + "%입니다.");
    }
}
