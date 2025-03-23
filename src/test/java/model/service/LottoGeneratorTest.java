package model.service;

import org.junit.jupiter.api.Test;

class LottoGeneratorTest {

    @Test
    void lottoGenerate() {
        LottoGeneratorImpl lottoGenerator = new LottoGeneratorImpl();
        lottoGenerator.lottoGenerate(5);
    }
}