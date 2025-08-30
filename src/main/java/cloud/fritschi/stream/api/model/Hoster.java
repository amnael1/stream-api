package cloud.fritschi.stream.api.model;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document(collection = "hoster")
public class Hoster {

    @Id
    @NotNull
    private String id;

    @NotNull
    private String name;

    @NotNull
    private String icon;

    public Hoster() {

    }

    public Hoster(final String id, final String name, final String icon) {
        this.id = id;
        this.name = name;
        this.icon = icon;
    }

    public Hoster(final String name, final String icon) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.icon = icon;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getIcon() {
        return icon;
    }
}
