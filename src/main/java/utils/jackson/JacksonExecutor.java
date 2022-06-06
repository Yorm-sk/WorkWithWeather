package utils.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.jackson.clases_for_parsing.WeatherInfo;
import utils.request.RequestHolding;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;

public class JacksonExecutor {
    private static final Logger LOGGER = LogManager.getLogger(JacksonExecutor.class);

    public static WeatherInfo getWeatherForItsCoordinate(double lat, double lon){
        ObjectMapper objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        WeatherInfo weatherInfo = null;
        String path = "src/main/resources/jackson/weatherInfo.json";
        try {
            String result = RequestHolding.getStringFromResponse(lat, lon);
            StringReader reader = new StringReader(result);
            weatherInfo = objectMapper.readValue(reader, WeatherInfo.class);
            objectMapper.writeValue(new File(path), weatherInfo);
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
        return weatherInfo;
    }
}
