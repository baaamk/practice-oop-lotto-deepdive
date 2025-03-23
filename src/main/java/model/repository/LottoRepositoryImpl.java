package model.repository;

import model.service.Lotto;
import model.service.LottoGenerator;

import java.util.ArrayList;
import java.util.List;

public class LottoRepositoryImpl implements LottoRepository{
    private static final LottoRepositoryImpl instance = new LottoRepositoryImpl();
    private final List<Lotto> lotto = new ArrayList<>();

    public static LottoRepositoryImpl getInstance() {
        return instance;
    }

    @Override
    public void saveGeneratedLotto(Lotto generatedNumber) {
        lotto.add(generatedNumber);
    }

    @Override
    public List<Lotto> getLotto() {
        return lotto;
    }

}
