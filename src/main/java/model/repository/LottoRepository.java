package model.repository;

import model.service.Lotto;

public interface LottoRepository {
    void saveGeneratedLotto(Lotto lotto);
}
