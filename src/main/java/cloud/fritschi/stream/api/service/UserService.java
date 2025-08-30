package cloud.fritschi.stream.api.service;

import cloud.fritschi.stream.api.exception.UserNotFoundException;
import cloud.fritschi.stream.api.exchange.request.UserCreateRequest;
import cloud.fritschi.stream.api.exchange.request.UserUpdateRequest;
import cloud.fritschi.stream.api.mapper.UserMapper;
import cloud.fritschi.stream.api.model.User;
import cloud.fritschi.stream.api.repository.UserRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(final UserRepository userRepository, final UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public Mono<User> createUser(final User user) {
        return userRepository
                .findBySub(user.getSub())
                .switchIfEmpty(userRepository.save(user));
    }

    public Mono<User> create(final UserCreateRequest request) {
        return createUser(userMapper.toEntity(request));
    }

    public Flux<User> getAllUsers(final Pageable pageable) {
        return userRepository.findAllBy(pageable);
    }

    public Mono<User> updateUser(final User user) {
        return userRepository.save(user);
    }

    public Mono<User> update(final String id, final UserUpdateRequest request) {
        return userRepository.findById(id)
                .switchIfEmpty(Mono.error(new UserNotFoundException(id)))
                .flatMap(existing -> {
                    userMapper.applyUpdates(existing, request);
                    return userRepository.save(existing);
                });
    }

    public Mono<Void> deleteUser(final String id) {
        return userRepository.deleteById(id);
    }

    public Mono<Void> deleteStrict(final String id) {
        return userRepository.findById(id)
                .switchIfEmpty(Mono.error(new UserNotFoundException(id)))
                .flatMap(userRepository::delete);
    }

}
