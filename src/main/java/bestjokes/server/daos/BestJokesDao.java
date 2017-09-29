package bestjokes.server.daos;

import bestjokes.server.entities.SimpleMsg;
import java.util.List;

/**
 * Created by Ilya Zhuravskiy on 18.07.2017.
 */
public interface BestJokesDao {

    /**
     * Adds message to the server
     * @param msg Message text to save
     * @param timestamp Timestamp for added message
     */
    public void add(String msg, long timestamp);

    /**
     * Gets all messages from the server
     */
    public List<SimpleMsg> getAll();
}
