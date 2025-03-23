import model.repository.LottoRepository;
import model.repository.LottoRepositoryImpl;
import model.service.LottoGenerator;
import model.service.LottoGeneratorImpl;

public class AppConfig {
    public LottoGenerator lottoGenerator() {
        return new LottoGeneratorImpl();
    }

    public LottoRepository lottoRepository() {
        return LottoRepositoryImpl.getInstance();
    }
}
