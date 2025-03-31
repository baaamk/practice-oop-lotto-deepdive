package model.domain;

import model.repository.LottoRepository;
import model.repository.LottoRepositoryImpl;
import model.repository.LottoWinning;
import model.repository.LottoWinningImpl;
import model.service.calculator.Calculator;
import model.service.matcher.LottoMatcher;
import model.service.money_manager.MoneyInput;
import model.service.saver.LottoSaver;

import java.util.List;

public class LottoService {
    private final Calculator calculator;
    private final LottoWinning lottoWinning;
    private final LottoRepository lottoRepository;
    private final LottoMatcher lottoMatcher;
    private final LottoSaver lottoSaver;
    private final MoneyInput moneyInput;

    public LottoService(Calculator calculator, LottoMatcher lottoMatcher, LottoSaver lottoSaver, MoneyInput moneyInput) {
        this.calculator = calculator;
        this.lottoWinning = LottoWinningImpl.getInstance();
        this.lottoRepository = LottoRepositoryImpl.getInstance();
        this.lottoMatcher = lottoMatcher;
        this.lottoSaver = lottoSaver;
        this.moneyInput = moneyInput;
    }

    public void lottoFactory(int money) {
        int count = moneyInput.countLotto(money);
        lottoSaver.lottoSave(count);
    }

    public int getCount() {
        return moneyInput.getCount();
    }

    public List<List<Integer>> getLotto() {
        return lottoRepository.getLottoNumbers();
    }

    public void compare(Lotto targetLotto, int bonusNumber) {
        lottoMatcher.match(targetLotto, lottoRepository.getLotto().iterator(), bonusNumber);
    }

    public double calculateService(int money) {
        return calculator.percentCalculator(money);
    }

    public int[] setLottoWinning() {
        return lottoWinning.getMatches();
    }

}
