package cloud.fritschi.stream.api.service;

import cloud.fritschi.stream.api.model.Hoster;
import cloud.fritschi.stream.api.repository.HosterRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class HosterService {

    private final HosterRepository hosterRepository;

    public HosterService(final HosterRepository hosterRepository) {
        this.hosterRepository = hosterRepository;
    }

    public Mono<Hoster> createHoster(final Hoster hoster) {
        return hosterRepository.save(hoster);
    }

    public Flux<Hoster> getAllHosters() {
        return hosterRepository.findAll();
    }

    public Mono<Hoster> updateHoster(final Hoster hoster) {
        return hosterRepository.save(hoster);
    }

    public Mono<Void> deleteHoster(final String id) {
        return hosterRepository.deleteById(id);
    }

}