package cloud.fritschi.stream.api.repository;

import cloud.fritschi.stream.api.model.Hoster;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface HosterRepository extends ReactiveMongoRepository<Hoster, String> {

    Flux<Hoster> findByName(String name);

}
