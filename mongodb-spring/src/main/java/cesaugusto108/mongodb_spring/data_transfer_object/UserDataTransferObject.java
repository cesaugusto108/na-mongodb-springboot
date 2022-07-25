package cesaugusto108.mongodb_spring.data_transfer_object;

import cesaugusto108.mongodb_spring.domain.entities.User;

import java.io.Serializable;

public class UserDataTransferObject implements Serializable {
    private static final long serialVersionUID = 1425190718534336218L;

    private String id;
    private String name;
    private String email;

    public UserDataTransferObject() {
    }

    public UserDataTransferObject(User user) {
        id = user.getId();
        name = user.getName();
        email = user.getEmail();
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
