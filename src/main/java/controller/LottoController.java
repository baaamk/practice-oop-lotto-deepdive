package controller;

import model.domain.LottoService;
import view.input.UserInput;
import view.input.UserInputImpl;
import view.output.UserOutput;
import view.output.UserOutputImpl;

import java.util.HashSet;
import java.util.List;

import static model.domain.Error.*;

public class LottoController {
    private final UserInput userInput;
    private final UserOutput userOutput;
    private final LottoService lottoService;

    public LottoController(LottoService lottoSave) {
        this.userInput = new UserInputImpl();
        this.userOutput = new UserOutputImpl();
        this.lottoService = lottoSave;
    }

    public void run() {
        lottoMainService(getInputMoney());
        getPrintResult(getInputMoney());
    }

    private void getPrintResult(int inputMoney) {
        userOutput.printResult(lottoService.setLottoWinning() ,lottoService.calculateService(inputMoney));
    }

    private void lottoMainService(int inputMoney) {
        List<Integer> targetLotto = userInput.inputNumber();
        int bonusNumber = userInput.inputBonusNumber();
        lottoValidation(targetLotto, bonusNumber);
        lottoService.compare(targetLotto, bonusNumber);
        lottoService.calculateService(inputMoney);
    }

    private void lottoValidation(List<Integer> targetLotto, int bonusNumber) {
        if (targetLotto.size() != 6) {
            throw new IllegalArgumentException(INVALID_NUMBERS.getErrorMessage());
        }
        if (hasDuplicates(targetLotto)) {
            throw new IllegalArgumentException(DUPLICATED_NUMBER.getErrorMessage());
        }
        if (targetLotto.contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATED_BONUS_NUMBER.getErrorMessage());
        }

    }

    private boolean hasDuplicates(List<Integer> targetLotto) {
        return new HashSet<>(targetLotto).size() < targetLotto.size();
    }

    private int getInputMoney() {
        int inputMoney = userInput.inputMoney();
        lottoService.lottoService(inputMoney);
        userOutput.printLotto(lottoService.getCount(), lottoService.getLotto());
        return inputMoney;
    }
}
