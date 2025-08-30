package cloud.fritschi.stream.api.model;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document(collection = "episode")
public class Episode {

    @Id
    @NotNull
    private String id;

    @NotNull
    private String name;

    @NotNull
    private String title;

    @NotNull
    private String description;

    @DBRef
    @NotNull
    private Season season;

    public Episode() {

    }

    public Episode(final String id, final String name, final String title, final String description, final Season season) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.description = description;
        this.season = season;
    }

    public Episode(final String name, final String title, final String description, Season season) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.title = title;
        this.description = description;
        this.season = season;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }
}
