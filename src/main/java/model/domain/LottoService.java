package model.domain;

import model.dto.LottoWinningDTO;
import model.repository.LottoRepository;
import model.repository.LottoRepositoryImpl;
import model.service.LottoWinning;
import model.service.calculator.Calculator;
import model.service.matcher.LottoMatcher;
import model.service.money_manager.MoneyInput;
import model.service.saver.LottoSaver;
import model.service.validator.Validator;

import java.util.ArrayList;
import java.util.List;

import static model.service.LottoWinning.*;

public class LottoService {
    private final Calculator calculator;
    private final LottoRepository lottoRepository;
    private final LottoMatcher lottoMatcher;
    private final LottoSaver lottoSaver;
    private final MoneyInput moneyInput;
    private final Validator validator;

    public LottoService(Calculator calculator, LottoMatcher lottoMatcher, LottoSaver lottoSaver, MoneyInput moneyInput, Validator validator) {
        this.calculator = calculator;
        this.validator = validator;
        this.lottoRepository = LottoRepositoryImpl.getInstance();
        this.lottoMatcher = lottoMatcher;
        this.lottoSaver = lottoSaver;
        this.moneyInput = moneyInput;
    }

    public void compareLotto(List<Integer> targetLotto, int bonusNumber, Lotto lotto) {
        validateLotto(targetLotto, bonusNumber);
        compare(lotto,bonusNumber);
    }

    public List<LottoWinningDTO> getWinningResults() {
        List<LottoWinningDTO> results = new ArrayList<>();
        results.add(new LottoWinningDTO("3개 일치 (5,000원)", FIFTH.getCount()));
        results.add(new LottoWinningDTO("4개 일치 (50,000원)", FOURTH.getCount()));
        results.add(new LottoWinningDTO("5개 일치 (1,500,000원)", THIRD.getCount()));
        results.add(new LottoWinningDTO("5개 일치, 보너스 볼 일치 (30,000,000원)", SECOND.getCount()));
        results.add(new LottoWinningDTO("6개 일치 (2,000,000,000원)", FIRST.getCount()));
        return results;
    }


    public void createLotto(int money) {
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

    private void validateLotto(List<Integer> targetLotto, int bonusNumber) {
        validator.validateBonusNumber(targetLotto, bonusNumber);
    }

    public int validateMoney(String inputNumber) {
        return validator.validateNumber(inputNumber);
    }

}
