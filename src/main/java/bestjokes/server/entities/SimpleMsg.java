package bestjokes.server.entities;

/**
 * Class describes an instance of simple message, applicable to the DB table 'simple_messages'.
 */
public class SimpleMsg {

    private int id;
    private String message;
    private Long timestamp;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "SimpleMsg{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
