package arkham.knight.template.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Comment {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String email;
    private String body;


    public Comment() {
    }


    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getBody() { return body; }

    public void setBody(String body) { this.body = body; }
}
