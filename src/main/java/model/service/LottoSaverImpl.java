    package model.service;

    import model.repository.LottoRepository;
    import model.repository.LottoRepositoryImpl;

    public class LottoSaverImpl implements LottoSaver {
        private final LottoRepository lottoRepository;
        private final LottoGenerator lottoGenerator;

        public LottoSaverImpl(LottoGenerator lottoGenerator, LottoRepository lottoRepository) {
            this.lottoGenerator = lottoGenerator;
            this.lottoRepository = lottoRepository;
        }

        @Override
        public void lottoSave(int count) {
            for (int i = 0; i < count; i++) {
                lottoRepository.saveGeneratedLotto(lottoGenerator.generateLotto());
            }
        }
    }
