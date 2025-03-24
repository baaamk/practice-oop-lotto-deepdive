package model.service;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;

public class LottoGeneratorImpl implements LottoGenerator {
    private final MoneyInput moneyInput;

    public LottoGeneratorImpl(MoneyInput moneyInput) {
        this.moneyInput = moneyInput;
    }

    public void lottoGenerate() {
        for (int i = 0; i < moneyInput.getCount(); i++) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            Collections.sort(lotto.getNumbers());
            System.out.println(lotto);
        }
    }

}
