import controller.LottoController;
import model.repository.LottoRepository;
import model.repository.LottoRepositoryImpl;
import model.domain.LottoService;
import model.service.money_manager.MoneyInput;
import model.service.money_manager.MoneyInputImpl;
import model.service.calculator.Calculator;
import model.service.calculator.CalculatorImpl;
import model.service.generator.LottoGenerator;
import model.service.generator.LottoGeneratorImpl;
import model.service.matcher.LottoMatcher;
import model.service.matcher.LottoMatcherImpl;
import model.service.saver.LottoSaver;
import model.service.saver.LottoSaverImpl;
import model.service.validator.Validator;
import model.service.validator.ValidatorImpl;

public final class AppConfig {
    public LottoController lottoController() {
        return new LottoController(lottoService());
    }

    private LottoGenerator lottoGenerator() {
        return new LottoGeneratorImpl();
    }

    private MoneyInput moneyInput() {
        return new MoneyInputImpl();
    }

    private Calculator calculator() {
        return new CalculatorImpl();
    }

    private LottoRepository lottoRepository() {
        return LottoRepositoryImpl.getInstance();
    }



    private LottoMatcher lottoMatcher() {
        return new LottoMatcherImpl();
    }

    private LottoSaver lottoSaver() {
        return new LottoSaverImpl(lottoGenerator(), lottoRepository());
    }

    private Validator validator() {
        return new ValidatorImpl();
    }

    private LottoService lottoService() {
        return new LottoService(calculator(), lottoMatcher(), lottoSaver(), moneyInput(), validator());
    }


}
