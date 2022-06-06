import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.jackson.JacksonExecutor;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);
    public static void main(String[] args) {
        LOGGER.info(JacksonExecutor.getWeatherForItsCoordinate(50.4160148, 30.4006088));
    }
}
