package model.service.money_manager;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


class MoneyInputImplTest {

    private MoneyInput moneyInput;

    @Test
    void countLotto() {
        int countLotto = moneyInput.countLotto(1000);
        Assertions.assertThat(countLotto).isEqualTo(1);

    }
}