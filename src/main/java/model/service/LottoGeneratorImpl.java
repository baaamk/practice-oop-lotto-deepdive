package model.service;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;

public class LottoGeneratorImpl implements LottoGenerator {

    public Lotto lottoGenerate(int lottoCount) {
        Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        Collections.sort(lotto.getNumbers());
        return lotto;
    }

}
