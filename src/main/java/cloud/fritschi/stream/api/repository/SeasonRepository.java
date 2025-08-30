package cloud.fritschi.stream.api.repository;

import cloud.fritschi.stream.api.model.Season;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface SeasonRepository extends ReactiveMongoRepository<Season, String> {

    Flux<Season> findBySeriesId(String seriesId);

}
