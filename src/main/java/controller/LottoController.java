package controller;

import model.domain.Lotto;
import model.domain.LottoService;
import view.input.UserInput;
import view.input.UserInputImpl;
import view.output.UserOutput;
import view.output.UserOutputImpl;

import java.util.List;

import static model.domain.Error.DUPLICATED_BONUS_NUMBER;

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
        int inputMoney = getInputMoney();
        lottoMainService(inputMoney);
        getPrintResult(inputMoney);
    }

    private void getPrintResult(int inputMoney) {
        userOutput.printResult(lottoService.setLottoWinning() ,lottoService.calculateService(inputMoney));
    }

    private void lottoMainService(int inputMoney) {
        List<Integer> targetLotto = userInput.inputNumber();
        Lotto numbers = new Lotto(targetLotto);
        int bonusNumber = userInput.inputBonusNumber();
        bonusNumberValidate(numbers, bonusNumber);
        lottoService.compare(numbers, bonusNumber);
        lottoService.calculateService(inputMoney);
    }

    private void bonusNumberValidate(Lotto targetLotto, int bonusNumber) {
        if (targetLotto.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATED_BONUS_NUMBER.getErrorMessage());
        }
    }



    private int getInputMoney() {
        int inputMoney = userInput.inputMoney();
        lottoService.lottoService(inputMoney);
        userOutput.printLotto(lottoService.getCount(), lottoService.getLotto());
        return inputMoney;
    }
}
