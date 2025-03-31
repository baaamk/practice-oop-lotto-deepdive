package model.repository;

import model.domain.Lotto;

import java.util.ArrayList;
import java.util.Collections;
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

    public List<List<Integer>> getLottoNumbers() {
        List<List<Integer>> lottoNumbersList = new ArrayList<>();
        for (Lotto lotto : this.lotto) {
            Collections.sort(lotto.getNumbers());
            lottoNumbersList.add(lotto.getNumbers());
        }
        return lottoNumbersList;
    }

}
