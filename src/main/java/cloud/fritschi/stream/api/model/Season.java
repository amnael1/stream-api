package cloud.fritschi.stream.api.model;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document(collection = "season")
public class Season {

    @Id
    @NotNull
    private String id;

    @NotNull
    private String name;

    @NotNull
    private String description;

    @DBRef
    @NotNull
    private Series series;

    public Season() {

    }

    public Season(final String id, final String name, final String description, final Series series) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.series = series;
    }

    public Season(final String name, final String description, final Series series) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.description = description;
        this.series = series;
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

    public Series getSerie() {
        return series;
    }

    public void setSerie(Series series) {
        this.series = series;
    }
}
