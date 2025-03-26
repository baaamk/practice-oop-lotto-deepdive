package model.service;

import org.junit.jupiter.api.Test;

class LottoGeneratorTest {

    @Test
    void lottoGenerate() {
        MoneyInputImpl moneyInput = new MoneyInputImpl();
        moneyInput.countLotto(10000);
    }
}