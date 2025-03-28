package view.output;

import model.domain.Lotto;

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
    public void printResult(int[] matches, double percent) {
        System.out.println("당첨 통계\n" + "---");
        System.out.println("3개 일치 (5,000원) - " + matches[0] + "개");
        System.out.println("4개 일치 (50,000원) - " + matches[1] + "개");
        System.out.println("5개 일치 (1,500,000원) - " + matches[2] + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + matches[3] + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + matches[4] + "개");
        System.out.println("총 수익률은 " + percent + "%입니다.");
    }
}
