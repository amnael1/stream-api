package cloud.fritschi.stream.api.service;

import cloud.fritschi.stream.api.model.Season;
import cloud.fritschi.stream.api.repository.SeasonRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class SeasonService {

    private final SeasonRepository seasonRepository;

    public SeasonService(final SeasonRepository seasonRepository) {
        this.seasonRepository = seasonRepository;
    }

    public Mono<Season> createSeason(final Season season) {
        return seasonRepository.save(season);
    }

    public Flux<Season> getAllSeasons() {
        return seasonRepository.findAll();
    }

    public Mono<Season> updateSeason(final Season season) {
        return seasonRepository.save(season);
    }

    public Mono<Void> deleteSeason(final String id) {
        return seasonRepository.deleteById(id);
    }

}