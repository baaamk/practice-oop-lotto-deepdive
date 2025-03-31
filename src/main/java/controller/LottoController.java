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
        int inputMoney = getInputMoney();

        List<Integer> targetLotto = getLottoNumbers();
        int bonusNumber = getBonusNumber();

        validateBonusNumber(targetLotto, bonusNumber);
        Lotto numbers = new Lotto(targetLotto);
        lottoService.compare(numbers, bonusNumber);
        userOutput.printResult(lottoService.setLottoWinning(), lottoService.calculateService(inputMoney));
    }

    private int getInputMoney() {
        String inputMoney = userInput.inputMoney();
        if (!validateNumber(inputMoney)) {
            throw new IllegalArgumentException(Error.INVALID_NUMBER_FORMAT.getErrorMessage());
        }
        int validatedMoney = Integer.parseInt(inputMoney);
        lottoService.lottoService(validatedMoney);
        userOutput.printLotto(lottoService.getCount(), lottoService.getLotto());
        return validatedMoney;
    }

    private List<Integer> getLottoNumbers() {
        try {
            return Arrays.stream(userInput.inputNumber().split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Error.INVALID_NUMBER_FORMAT.getErrorMessage());
        }
    }

    private int getBonusNumber() {
        try {
            return Integer.parseInt(userInput.inputBonusNumber());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Error.INVALID_NUMBER_FORMAT.getErrorMessage());
        }
    }

    private void validateBonusNumber(List<Integer> targetLotto, int bonusNumber) {
        if (targetLotto.contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATED_BONUS_NUMBER.getErrorMessage());
        }
    }

    private boolean validateNumber(String inputNumber) {
        try {
            Integer.parseInt(inputNumber);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
