package model.service.generator;

import camp.nextstep.edu.missionutils.Randoms;
import model.domain.Lotto;

public class LottoGeneratorImpl implements LottoGenerator {

        public Lotto generateLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }


}
