import java.net.URL;
import java.net.HttpURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class GeoInformation {
    private String apiKey = "6bbea633e2abbdceff1fcb5cb8b2be23";
    private String startCity;
    private String endCity;

    public GeoInformation(String startCity, String endCity) {
        this.startCity = startCity.toLowerCase();
        this.endCity = endCity.toLowerCase();
    }

    private String getLat(String loc) throws IOException {
        URL apiURL = new URL("http://api.openweathermap.org/geo/1.0/direct?q=" + loc + "&limit=1&appid=" + apiKey);
        HttpURLConnection conn = (HttpURLConnection) apiURL.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();

        int responseCode = conn.getResponseCode();

        if (responseCode != 200) {
            throw new RuntimeException("HttpResponseCode: " + responseCode);
        } else {
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // Parse JSON response and extract latitude
            String jsonString = response.toString();
            int latIndex = jsonString.indexOf("\"lat\":");
            if (latIndex != -1) {
                int startIndex = jsonString.indexOf(":", latIndex) + 1;
                int endIndex = jsonString.indexOf(",", startIndex);
                String lat = jsonString.substring(startIndex, endIndex).trim();
                return lat;
            } else {
                return "Longitude not found";
            }
        }
    }

    private String getLon(String loc) throws IOException {
        URL apiURL = new URL("http://api.openweathermap.org/geo/1.0/direct?q=" + loc + "&limit=1&appid=" + apiKey);
        HttpURLConnection conn = (HttpURLConnection) apiURL.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();

        int responseCode = conn.getResponseCode();

        if (responseCode != 200) {
            throw new RuntimeException("HttpResponseCode: " + responseCode);
        } else {
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // Parse JSON response and extract latitude
            String jsonString = response.toString();
            int lonIndex = jsonString.indexOf("\"lon\":");
            if (lonIndex != -1) {
                int startIndex = jsonString.indexOf(":", lonIndex) + 1;
                int endIndex = jsonString.indexOf(",", startIndex);
                String lon = jsonString.substring(startIndex, endIndex).trim();
                return lon;
            } else {
                return "Latitude not found";
            }
        }
    }

    public LatLong getCoordinatesStart() throws IOException {
        return new LatLong(getLat(startCity), getLon(startCity));
    }

    public LatLong getCoordinatesEnd() throws IOException {
        return new LatLong(getLat(endCity), getLon(endCity));
    }

}
