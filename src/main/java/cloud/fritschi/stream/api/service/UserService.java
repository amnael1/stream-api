package cloud.fritschi.stream.api.service;

import cloud.fritschi.stream.api.model.User;
import cloud.fritschi.stream.api.repository.UserRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Mono<User> createUser(final User user) {
        return userRepository
                .findBySub(user.getSub())
                .switchIfEmpty(userRepository.save(user));
    }


    public Flux<User> getAllUsers(final Pageable pageable) {
        return userRepository.findAllBy(pageable);
    }

    public Mono<User> updateUser(final User user) {
        return userRepository.save(user);
    }


    public Mono<Void> deleteUser(final String id) {
        return userRepository.deleteById(id);
    }

}
