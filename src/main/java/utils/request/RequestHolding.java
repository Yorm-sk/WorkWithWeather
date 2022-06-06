package utils.request;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class RequestHolding {
    private static final Logger LOGGER = LogManager.getLogger(RequestHolding.class);

    public static String getStringFromResponse(double lat, double lon) {
        StringBuilder result = new StringBuilder();
        try {
            URL url =
                    new URL("https://api.openweathermap.org/data/2.5/weather?lat=" + lat +
                            "&lon=" + lon +
                            "&appid=307be471edad0bcb829b53082c0b00a7" +
                            "&units=metric");

            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                result.append(inputLine);
            }
            in.close();
            con.disconnect();

        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
        return result.toString();
    }
}
