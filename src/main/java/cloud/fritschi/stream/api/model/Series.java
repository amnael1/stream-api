package cloud.fritschi.stream.api.model;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document(collection = "series")
public class Series {

    @Id
    @NotNull
    private String id;

    @Indexed(unique = true)
    @NotNull
    private String imdbId;

    @NotNull
    private String name;

    @NotNull
    private String description;

    public Series() {

    }

    public Series(final String id, final String name, final String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Series(final String name, final String description) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }
}
