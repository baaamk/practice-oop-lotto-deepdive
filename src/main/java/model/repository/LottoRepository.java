package model.repository;

import model.domain.Lotto;

import java.util.List;

public interface LottoRepository {
    void saveGeneratedLotto(Lotto lotto);
    List<Lotto> getLotto();
    List<List<Integer>> getLottoNumbers();
}
