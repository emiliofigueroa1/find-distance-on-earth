import java.net.URL;
import java.net.HttpURLConnection;
import java.net.URLEncoder;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class GeoInformation {
    private String apiKey = "6bbea633e2abbdceff1fcb5cb8b2be23";
    private String startCity;
    private String endCity;

    public GeoInformation(String startCity, String endCity) {
        this.startCity = startCity.toLowerCase();
        this.endCity = endCity.toLowerCase();
    }

    private String getEncodedCity(String city) throws IOException {
        return URLEncoder.encode(city, StandardCharsets.UTF_8.toString());
    }

    private String getGeoData(String loc, String key) throws IOException {
        String encodedCity = getEncodedCity(loc);
        URL apiURL = new URL("http://api.openweathermap.org/geo/1.0/direct?q=" + encodedCity + "&limit=1&appid=" + apiKey);
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

            // Parse JSON response and extract the required data
            String jsonString = response.toString();
            int keyIndex = jsonString.indexOf("\"" + key + "\":");
            if (keyIndex != -1) {
                int startIndex = jsonString.indexOf(":", keyIndex) + 1;
                int endIndex = jsonString.indexOf(",", startIndex);
                return jsonString.substring(startIndex, endIndex).trim();
            } else {
                return key.equals("lat") ? "Latitude not found" : "Longitude not found";
            }
        }
    }

    private String getLat(String loc) throws IOException {
        return getGeoData(loc, "lat");
    }

    private String getLon(String loc) throws IOException {
        return getGeoData(loc, "lon");
    }

    public LatLong getCoordinatesStart() throws IOException {
        return new LatLong(getLat(startCity), getLon(startCity));
    }

    public LatLong getCoordinatesEnd() throws IOException {
        return new LatLong(getLat(endCity), getLon(endCity));
    }
}
