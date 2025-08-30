package cloud.fritschi.stream.api.repository;

import cloud.fritschi.stream.api.model.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface UserRepository extends ReactiveMongoRepository<User, String> {

    Mono<User> findBySub(final String sub);
    Flux<User> findAllBy(final Pageable pageable);

}
