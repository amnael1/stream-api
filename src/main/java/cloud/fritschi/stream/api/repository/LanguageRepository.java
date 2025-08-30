package cloud.fritschi.stream.api.repository;

import cloud.fritschi.stream.api.model.Language;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageRepository extends ReactiveMongoRepository<Language, String> {

}
