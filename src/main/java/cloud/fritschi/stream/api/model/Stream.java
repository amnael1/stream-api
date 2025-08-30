package cloud.fritschi.stream.api.model;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document(collection = "stream")
public class Stream {

    @Id
    @NotNull
    private String id;

    @DBRef
    @NotNull
    private Hoster hoster;

    @DBRef
    @NotNull
    private Language language;

    @DBRef
    @NotNull
    private Episode episode;

    @NotNull
    private String url;

    public Stream() {

    }

    public Stream(final String id, final Hoster hoster, final Language language, final Episode episode, final String url) {
        this.id = id;
        this.hoster = hoster;
        this.language = language;
        this.episode = episode;
        this.url = url;
    }

    public Stream(final Hoster hoster, final Language language, final String url) {
        this.id = UUID.randomUUID().toString();
        this.hoster = hoster;
        this.language = language;
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public Hoster getHoster() {
        return hoster;
    }

    public void setHoster(Hoster hoster) {
        this.hoster = hoster;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public Episode getEpisode() {
        return episode;
    }

    public void setEpisode(Episode episode) {
        this.episode = episode;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
