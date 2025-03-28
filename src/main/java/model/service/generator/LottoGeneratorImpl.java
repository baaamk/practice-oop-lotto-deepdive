package model.service.generator;

import camp.nextstep.edu.missionutils.Randoms;
import model.domain.Lotto;
import model.domain.Unit;

import static model.domain.Unit.*;

public class LottoGeneratorImpl implements LottoGenerator {

        public Lotto generateLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(MIN_NUMBER.getValue(), MAX_NUMBER.getValue(), UNIT_LOTTO_NUMBER.getValue()));
    }


}
