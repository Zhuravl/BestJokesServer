package bestjokes.server.controllers;

import bestjokes.server.entities.SimpleMsg;
import bestjokes.server.services.BestJokesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Ilya Zhuravskiy on 17.07.2017.
 */
@Api(tags = {"Common"}, description = "Operations with records")
@RestController
public class BestJokesController {

    private static Logger log = LogManager.getLogger();
    private final BestJokesService bestJokesService = new BestJokesService();

    @ApiOperation(value = "Post joke on the server")
    @RequestMapping(value = "/addMsg", method = RequestMethod.GET)
    public String postJoke (String message) {

        log.info("Post joke on the server", message);

        return bestJokesService.addMsg(message);
    }

    @ApiOperation(value = "Get all jokes from the server")
    @RequestMapping(value = "/getAllMsgs", method = RequestMethod.GET)
    public List<SimpleMsg> getAllJokes() {

        log.info("Get all jokes from the server");

        return bestJokesService.getAllMsgs();
    }
}
