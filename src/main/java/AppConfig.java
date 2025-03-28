import controller.LottoController;
import model.repository.LottoRepository;
import model.repository.LottoRepositoryImpl;
import model.repository.LottoWinning;
import model.repository.LottoWinningImpl;
import model.service.*;
import model.service.MoneyInput;
import model.service.MoneyInputImpl;
import model.service.calculator.Calculator;
import model.service.calculator.CalculatorImpl;

public class AppConfig {
    public LottoGenerator lottoGenerator() {
        return new LottoGeneratorImpl();
    }

    public MoneyInput moneyInput() {
        return new MoneyInputImpl();
    }

    public Calculator calculator() {
        return new CalculatorImpl(lottoWinning());
    }
    public LottoRepository lottoRepository() {
        return LottoRepositoryImpl.getInstance();
    }

    public LottoWinning lottoWinning() {
        return LottoWinningImpl.getInstance();
    }

    public LottoMatcher lottoMatcher() {
        return new LottoMatcherImpl(lottoWinning());
    }

    public LottoSaver lottoSaver() {
        return new LottoSaverImpl(lottoGenerator(),lottoRepository());
    }

    public LottoService lottoService() {
        return new LottoService(calculator(), lottoMatcher(), lottoSaver(), moneyInput());
    }

    public LottoController lottoController() {
        return new LottoController(lottoService());
    }

}
