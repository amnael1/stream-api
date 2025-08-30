package cloud.fritschi.stream.api.model;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document(collection = "language")
public class Language {

    @Id
    @NotNull
    private String id;

    @NotNull
    private String isoCode;

    @NotNull
    private String name;

    public Language() {

    }

    public Language(final String id, final String isoCode, final String name) {
        this.id = id;
        this.isoCode = isoCode;
        this.name = name;
    }

    public Language(final String isoCode, final String name) {
        this.id = UUID.randomUUID().toString();
        this.isoCode = isoCode;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getIsoCode() {
        return isoCode;
    }

    public void setIsoCode(String isoCode) {
        this.isoCode = isoCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
