package cloud.fritschi.stream.api.model;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document(collection = "user")
public class User {

    @Id
    @NotNull
    private String id;

    @NotNull
    @Indexed(unique = true, background = true)
    private String sub;

    @NotNull
    private String email;

    public User() {

    }

    public User(final String id, final String sub, final String email) {
        this.id = id;
        this.sub = sub;
        this.email = email;
    }

    public User(final String sub, final String email) {
        this.id = UUID.randomUUID().toString();
        this.sub = sub;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
