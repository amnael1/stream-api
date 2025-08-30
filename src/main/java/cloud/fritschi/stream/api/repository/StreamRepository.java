package cloud.fritschi.stream.api.repository;

import cloud.fritschi.stream.api.model.Stream;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface StreamRepository extends ReactiveMongoRepository<Stream, String> {

    Flux<Stream> findByEpisodeId(String episodeId);

}
