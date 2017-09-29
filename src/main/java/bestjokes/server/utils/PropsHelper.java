package bestjokes.server.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Ilya Zhuravskiy on 28.09.2017.
 */
public class PropsHelper {

    private static Logger log = LogManager.getLogger();
    private static Properties prop = new Properties();
    private static InputStream input = null;
    private static String filePath = "queries.properties";

    /**
     * Returns property value from file
     * @param key Key of the expected record
     */
	public static String getPropertyByKey(String key) {

	    log.info("Get property with key " + key);

	    String result = null;
	    try {
            input = PropsHelper.class.getClassLoader().getResourceAsStream(filePath);
            prop.load(input);
            result = prop.getProperty(key);
        } catch (IOException e1) {
            e1.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        log.info("Property value is: '" + result + "'");
        return result;
	}
}
