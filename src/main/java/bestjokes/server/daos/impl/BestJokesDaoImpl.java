package bestjokes.server.daos.impl;

import bestjokes.server.daos.BestJokesDao;
import bestjokes.server.entities.SimpleMsg;
import bestjokes.server.utils.PropsHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Ilya Zhuravskiy on 22.08.2017.
 */
public class BestJokesDaoImpl implements BestJokesDao {

    private static Logger log = LogManager.getLogger();
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void add(String msg, long timestamp) {
        log.info("Save message to the server..");

        String query = PropsHelper.getPropertyByKey("addMsg");

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        Object[] args = new Object[] {msg, timestamp};

        int out = jdbcTemplate.update(query, args);

        if (out != 0){
            log.info("Message saved SUCCESSFULLY");
        } else {
            log.error("Message with text '" + msg + "' has NOT been saved!");
        }
    }

    @Override
    public List<SimpleMsg> getAll() {
        log.info("Get all messages from the server..");

        log.info("Get props 'getAll'");
        String query = PropsHelper.getPropertyByKey("getAll");
        log.info("Props 'getAll' is: " + query);
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        List<SimpleMsg> resultList = new ArrayList<SimpleMsg>();

        List<Map<String,Object>> empRows = jdbcTemplate.queryForList(query);

        for(Map<String,Object> empRow : empRows){
            SimpleMsg simpleMsg = new SimpleMsg();
            simpleMsg.setId((int)empRow.get("id"));
            simpleMsg.setMessage(String.valueOf(empRow.get("message")));
            simpleMsg.setTimestamp(Long.valueOf((String)empRow.get("timestamp")));
            resultList.add(simpleMsg);
        }

        log.info("SUCCESS. Count founded messages from DB: " + resultList.size());
        return resultList;
    }
}
