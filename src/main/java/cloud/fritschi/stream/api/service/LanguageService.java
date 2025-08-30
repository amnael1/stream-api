package cloud.fritschi.stream.api.service;

import cloud.fritschi.stream.api.model.Language;
import cloud.fritschi.stream.api.repository.LanguageRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class LanguageService {

    private final LanguageRepository languageRepository;

    public LanguageService(final LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    public Mono<Language> createLanguage(final Language language) {
        return languageRepository.save(language);
    }

    public Flux<Language> getAllLanguages() {
        return languageRepository.findAll();
    }

    public Mono<Language> updateLanguage(final Language language) {
        return languageRepository.save(language);
    }

    public Mono<Void> deleteLanguage(final String id) {
        return languageRepository.deleteById(id);
    }

}