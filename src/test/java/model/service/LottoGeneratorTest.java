package model.service;

import model.service.money_manager.MoneyInputImpl;
import org.junit.jupiter.api.Test;

class LottoGeneratorTest {

    @Test
    void lottoGenerate() {
        MoneyInputImpl moneyInput = new MoneyInputImpl();
        moneyInput.countLotto(10000);
    }
}