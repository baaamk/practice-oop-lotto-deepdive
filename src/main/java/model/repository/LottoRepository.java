package model.repository;

import model.service.Lotto;

import java.util.List;

public interface LottoRepository {
    void saveGeneratedLotto(Lotto lotto);
    List<Lotto> getLotto();
}
