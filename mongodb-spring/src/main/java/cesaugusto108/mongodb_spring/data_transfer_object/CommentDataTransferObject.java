package cesaugusto108.mongodb_spring.data_transfer_object;

import java.io.Serializable;
import java.util.Date;

public class CommentDataTransferObject implements Serializable {
    private static final long serialVersionUID = 7262143300006166884L;

    private String text;
    private Date date;
    private AuthorDataTransferObject authorDataTransferObject;

    public CommentDataTransferObject() {
    }

    public CommentDataTransferObject(String text, Date date, AuthorDataTransferObject authorDataTransferObject) {
        this.text = text;
        this.date = date;
        this.authorDataTransferObject = authorDataTransferObject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public AuthorDataTransferObject getAuthorDataTransferObject() {
        return authorDataTransferObject;
    }

    public void setAuthorDataTransferObject(AuthorDataTransferObject authorDataTransferObject) {
        this.authorDataTransferObject = authorDataTransferObject;
    }
}
