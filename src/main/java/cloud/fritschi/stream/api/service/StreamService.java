package cloud.fritschi.stream.api.service;

import cloud.fritschi.stream.api.model.Stream;
import cloud.fritschi.stream.api.repository.StreamRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class StreamService {

    private final StreamRepository streamRepository;

    public StreamService(final StreamRepository streamRepository) {
        this.streamRepository = streamRepository;
    }

    public Mono<Stream> createStream(final Stream stream) {
        return streamRepository.save(stream);
    }

    public Flux<Stream> getAllStreams() {
        return streamRepository.findAll();
    }

    public Mono<Stream> updateStream(final Stream stream) {
        return streamRepository.save(stream);
    }

    public Mono<Void> deleteStream(final String id) {
        return streamRepository.deleteById(id);
    }

}