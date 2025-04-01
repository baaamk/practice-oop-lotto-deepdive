package controller;

import model.domain.Lotto;
import model.domain.LottoService;
import model.domain.exception.Error;
import view.input.UserInput;
import view.input.UserInputImpl;
import view.output.UserOutput;
import view.output.UserOutputImpl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoController {
    private final UserInput userInput;
    private final UserOutput userOutput;
    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.userInput = new UserInputImpl();
        this.userOutput = new UserOutputImpl();
        this.lottoService = lottoService;
    }

    public void run() {
        int inputMoney = lottoService.validateMoney(userInput.inputMoney());
        lottoService.createLotto(inputMoney);
        printLotto();
        List<Integer> targetLotto = getLottoNumbers();
        int bonusNumber = getBonusNumber();
        lottoService.compareLotto(targetLotto, bonusNumber, new Lotto(targetLotto));
        printResult(inputMoney);
    }

    private void printResult(int inputMoney) {
        userOutput.printResult(lottoService.getWinningResults(), lottoService.calculateService(inputMoney));
    }

    private void printLotto() {
        userOutput.printLotto(lottoService.getCount(), lottoService.getLotto());
    }


    private List<Integer> getLottoNumbers() {
        try {
            return Arrays.stream(userInput.inputNumber().split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Error.INVALID_NUMBER_FORMAT);
        }
    }

    private int getBonusNumber() {
        try {
            return Integer.parseInt(userInput.inputBonusNumber());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Error.INVALID_NUMBER_FORMAT);
        }
    }

}
