package cloud.fritschi.stream.api.repository;

import cloud.fritschi.stream.api.model.Series;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface SeriesRepository extends ReactiveMongoRepository<Series, String> {

    Mono<Series> findByImdbId(String imdbId);

}
