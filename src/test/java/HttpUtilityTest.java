import org.junit.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Before;

public class HttpUtilityTest {

    @Test
    public void makeSureThatPageIsUp() {
        given().when().get("http://www.google.com").then().statusCode(200);
    }

    @Test
    public void testURL() throws Exception {
        String strUrl = "http://stackoverflow.com/about";

        try {
            URL url = new URL(strUrl);
            HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();
            urlConn.connect();

            assertEquals(HttpURLConnection.HTTP_OK, urlConn.getResponseCode());
        } catch (IOException e) {
            System.err.println("Error creating HTTP connection");
            e.printStackTrace();
            throw e;
        }
    }

    @Test
    public void testAPIKey() { fail(); }


}