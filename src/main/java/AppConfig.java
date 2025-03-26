import model.repository.LottoRepository;
import model.repository.LottoRepositoryImpl;
import model.repository.LottoWinning;
import model.repository.LottoWinningImpl;
import model.service.*;
import model.service.MoneyInput;
import model.service.MoneyInputImpl;
import view.UserInput;
import view.UserInputImpl;

public class AppConfig {
    public LottoGenerator lottoGenerator() {
        return new LottoGeneratorImpl(moneyInput());
    }

    public MoneyInput moneyInput() {
        return new MoneyInputImpl();
    }

    public LottoRepository lottoRepository() {
        return LottoRepositoryImpl.getInstance();
    }

    public LottoWinning lottoWinning() {
        return LottoWinningImpl.getInstance();
    }

    public InputNumber inputNumber() {
        return InputNumberImpl.getInstance();
    }

    public LottoMatcher lottoMatcher() {
        return new LottoMatcherImpl(lottoWinning());
    }

    public UserInput targetInput() {
        return new UserInputImpl();
    }

}
