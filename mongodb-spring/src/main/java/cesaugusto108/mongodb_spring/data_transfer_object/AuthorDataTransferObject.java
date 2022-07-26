package cesaugusto108.mongodb_spring.data_transfer_object;

import cesaugusto108.mongodb_spring.domain.entities.User;

import java.io.Serializable;

public class AuthorDataTransferObject implements Serializable {
    private static final long serialVersionUID = -6377953438231310716L;

    private String id;
    private String name;

    public AuthorDataTransferObject() {
    }

    public AuthorDataTransferObject(User author) {
        id = author.getId();
        name = author.getName();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
