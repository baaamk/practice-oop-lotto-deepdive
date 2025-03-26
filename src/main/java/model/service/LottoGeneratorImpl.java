package model.service;

import camp.nextstep.edu.missionutils.Randoms;
import model.repository.LottoRepository;
import model.repository.LottoRepositoryImpl;

public class LottoGeneratorImpl implements LottoGenerator {

        public Lotto generateLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }


}
