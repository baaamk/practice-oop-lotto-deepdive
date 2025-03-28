package controller;

import model.service.*;
import view.UserInput;
import view.UserInputImpl;
import view.UserOutput;
import view.UserOutputImpl;

import java.util.List;

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
        lottoService.compare(targetLotto, bonusNumber);
        lottoService.calculateService(inputMoney);
    }

    private int getInputMoney() {
        int inputMoney = userInput.inputMoney();
        lottoService.lottoService(inputMoney);
        userOutput.printLotto(lottoService.getCount(), lottoService.getLotto());
        return inputMoney;
    }
}
