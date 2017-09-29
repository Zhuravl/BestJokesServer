package bestjokes.server.services;

import bestjokes.server.daos.BestJokesDao;
import bestjokes.server.entities.SimpleMsg;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

/**
 * Created by Ilya Zhuravskiy on 18.07.2017.
 */
@Service
public class BestJokesService {

    private static Logger log = LogManager.getLogger();
    private ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
    private BestJokesDao dao = ctx.getBean("bestJokesDaoImpl", BestJokesDao.class);

    public String addMsg(String message){

        Instant instant = Instant.now();
        dao.add(message, instant.toEpochMilli());

        return "OK";
    }

    public List<SimpleMsg> getAllMsgs() {
        return dao.getAll();
    }
}
