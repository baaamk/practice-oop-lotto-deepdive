package model.service;

import org.junit.jupiter.api.Test;

class LottoGeneratorTest {

    @Test
    void lottoGenerate() {
        MoneyInputImpl moneyInput = new MoneyInputImpl();
        LottoGeneratorImpl lottoGenerator = new LottoGeneratorImpl(moneyInput);
        moneyInput.countLotto(10000);
    }
}