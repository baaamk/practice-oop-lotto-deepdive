package view;

import model.repository.LottoRepository;
import model.service.InputNumber;
import model.service.InputNumberImpl;
import model.service.Lotto;

public class TargetInputImpl {
    private final LottoRepository lottoRepository;
    private final InputNumber inputNumber;
    public TargetInputImpl(LottoRepository lottoRepository) {
        this.lottoRepository = lottoRepository;
        inputNumber = InputNumberImpl.getInstance();
    }

    public void inputNumber(Lotto lotto) {
        System.out.println("당첨 번호를 입력해 주세요.");
        inputNumber.inputNumber();
        System.out.println("보너스 번호를 입력해 주세요.");
        inputNumber.inputBonusNumber();
    }
}
