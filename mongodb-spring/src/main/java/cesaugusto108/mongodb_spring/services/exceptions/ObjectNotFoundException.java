package cesaugusto108.mongodb_spring.services.exceptions;

public class ObjectNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 5958602423498983345L;

    public ObjectNotFoundException(String message) {
        super(message);
    }
}
