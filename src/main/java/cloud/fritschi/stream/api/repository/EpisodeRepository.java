package cloud.fritschi.stream.api.repository;

import cloud.fritschi.stream.api.model.Episode;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface EpisodeRepository extends ReactiveMongoRepository<Episode, String> {

    Flux<Episode> findBySeasonId(String seasonId);

}
