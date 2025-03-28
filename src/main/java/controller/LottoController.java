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

import static model.domain.exception.Error.DUPLICATED_BONUS_NUMBER;

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
        lottoMainService(getInputMoney());
    }




    private void lottoMainService(int inputMoney) {
        List<Integer> targetLotto = changeInputNumberType();
        Lotto numbers = new Lotto(targetLotto);
        int bonusNumber = Integer.parseInt(userInput.inputBonusNumber());
        bonusNumberValidate(numbers, bonusNumber);
        lottoService.compare(numbers, bonusNumber);
        double calculateResult = lottoService.calculateService(inputMoney);
        userOutput.printResult(lottoService.setLottoWinning() , calculateResult);

    }

    private List<Integer> changeInputNumberType() {
        try {
            return Arrays.stream(userInput.inputNumber().split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Error.INVALID_NUMBER_FORMAT.getErrorMessage());
        }
    }

    private void bonusNumberValidate(Lotto targetLotto, int bonusNumber) {
        if (targetLotto.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATED_BONUS_NUMBER.getErrorMessage());
        }
    }



    private int getInputMoney() {
        String inputMoney = userInput.inputMoney();
        if (!validationNumber(inputMoney)) {
            throw new IllegalArgumentException(Error.INVALID_NUMBER_FORMAT.getErrorMessage());
        }
        int validatedMoney = Integer.parseInt(inputMoney);
        lottoService.lottoService(validatedMoney);
        userOutput.printLotto(lottoService.getCount(), lottoService.getLotto());
        return validatedMoney;
    }

    private boolean validationNumber(String inputNumber) {
        try {
            Integer.parseInt(inputNumber);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
