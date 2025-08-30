package cloud.fritschi.stream.api.service;

import cloud.fritschi.stream.api.model.Episode;
import cloud.fritschi.stream.api.repository.EpisodeRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EpisodeService {

    private final EpisodeRepository episodeRepository;

    public EpisodeService(final EpisodeRepository episodeRepository) {
        this.episodeRepository = episodeRepository;
    }

    public Mono<Episode> createEpisode(final Episode episode) {
        return episodeRepository.save(episode);
    }

    public Flux<Episode> getAllEpisodes() {
        return episodeRepository.findAll();
    }

    public Mono<Episode> updateEpisode(final Episode episode) {
        return episodeRepository.save(episode);
    }

    public Mono<Void> deleteEpisode(final String id) {
        return episodeRepository.deleteById(id);
    }

    public Flux<Episode> getEpisodesBySeasonId(final String seasonId) {
        return episodeRepository.findBySeasonId(seasonId);
    }

}