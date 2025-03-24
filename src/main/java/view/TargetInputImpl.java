package view;

import model.repository.LottoRepository;
import model.repository.LottoRepositoryImpl;
import model.service.InputNumber;
import model.service.InputNumberImpl;
import model.service.Lotto;

public class TargetInputImpl implements TargetInput{
    private final LottoRepository lottoRepository;
    private final InputNumber inputNumber;
    public TargetInputImpl() {
        lottoRepository = LottoRepositoryImpl.getInstance();
        inputNumber = InputNumberImpl.getInstance();
    }

    @Override
    public void inputNumber(Lotto lotto) {
        System.out.println("당첨 번호를 입력해 주세요.");
        inputNumber.inputNumber();
        System.out.println("보너스 번호를 입력해 주세요.");
        inputNumber.inputBonusNumber();
    }
}
