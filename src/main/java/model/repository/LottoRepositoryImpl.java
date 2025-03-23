package model.repository;

import model.service.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoRepositoryImpl implements LottoRepository{
    private static final LottoRepositoryImpl instance = new LottoRepositoryImpl();
    private final List<Lotto> lotto;

    private LottoRepositoryImpl() {
        this.lotto = new ArrayList<>();
    }

    public static LottoRepositoryImpl getInstance() {
        return instance;
    }

    public List<Lotto> getLotto() {
        return lotto;
    }

    @Override
    public void saveGeneratedLotto(Lotto lotto) {
        this.lotto.add(lotto);
    }
}
