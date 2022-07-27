package cesaugusto108.mongodb_spring.domain.entities;

import cesaugusto108.mongodb_spring.data_transfer_object.AuthorDataTransferObject;
import cesaugusto108.mongodb_spring.data_transfer_object.CommentDataTransferObject;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Document
public class Post implements Serializable {
    private static final long serialVersionUID = 519845110710556723L;

    private AuthorDataTransferObject authorDataTransferObject;

    @Id
    private String id;
    private Date date;
    private String title;
    private String body;

    private List<CommentDataTransferObject> commentDataTransferObjectList = new ArrayList<>();

    public Post() {
    }

    public Post(AuthorDataTransferObject authorDataTransferObject, String id, Date date, String title, String body) {
        this.authorDataTransferObject = authorDataTransferObject;
        this.id = id;
        this.date = date;
        this.title = title;
        this.body = body;
    }

    public AuthorDataTransferObject getAuthorDataTransferObject() {
        return authorDataTransferObject;
    }

    public void setAuthorDataTransferObject(AuthorDataTransferObject authorDataTransferObject) {
        this.authorDataTransferObject = authorDataTransferObject;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public List<CommentDataTransferObject> getCommentDataTransferObjectList() {
        return commentDataTransferObjectList;
    }

    protected void setCommentDataTransferObjectList(List<CommentDataTransferObject> commentDataTransferObjectList) {
        this.commentDataTransferObjectList = commentDataTransferObjectList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Post)) return false;
        Post post = (Post) o;
        return id.equals(post.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
