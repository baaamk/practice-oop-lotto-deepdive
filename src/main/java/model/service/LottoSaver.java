    package model.service;

    import model.repository.LottoRepository;
    import model.repository.LottoRepositoryImpl;

    public class LottoSaver {
        private final LottoRepository lottoRepository;
        private final LottoGenerator lottoGenerator;
        private final MoneyInput moneyInput;

        public LottoSaver(LottoGenerator lottoGenerator, MoneyInput moneyInput) {
            this.lottoGenerator = lottoGenerator;
            this.moneyInput = moneyInput;
            this.lottoRepository = LottoRepositoryImpl.getInstance();
        }

        public void lottoSaver() {
            for (int i = 0; i < moneyInput.getCount(); i++) {
                lottoRepository.saveGeneratedLotto(lottoGenerator.generateLotto());
            }
        }
    }
