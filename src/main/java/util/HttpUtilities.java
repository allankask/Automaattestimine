package util;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpUtilities {

    public static HttpURLConnection makeHttpGetRequest(String requestUrl) throws IOException {
        URL url = new URL(requestUrl);
        return (HttpURLConnection) url.openConnection();
    }

    public int getHTTPStatus(String connectionUrl) {
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet httpGetrequest = new HttpGet(connectionUrl);
        HttpResponse httpResponse = null;
        try {
            httpResponse = client.execute(httpGetrequest);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return httpResponse.getStatusLine().getStatusCode();
    }
}
