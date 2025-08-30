package cloud.fritschi.stream.api.service;

import cloud.fritschi.stream.api.model.Series;
import cloud.fritschi.stream.api.repository.SeriesRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class SeriesService {

    private final SeriesRepository seriesRepository;

    public SeriesService(final SeriesRepository seriesRepository) {
        this.seriesRepository = seriesRepository;
    }

    public Mono<Series> createSeries(final Series series) {
        return seriesRepository.save(series);
    }

    public Flux<Series> getAllSeries() {
        return seriesRepository.findAll();
    }

    public Mono<Series> updateSeries(final Series series) {
        return seriesRepository.save(series);
    }

    public Mono<Void> deleteSeries(final String id) {
        return seriesRepository.deleteById(id);
    }

}