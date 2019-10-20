package pl.sda.http;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;

class ApacheHttpClientExample {

    public static void main(String[] args) throws URISyntaxException, IOException {
        HttpClient httpClient = new DefaultHttpClient();

        HttpGet get = new HttpGet();
        get.setURI(new URI("https://pokeapi.co/api/v2/pokemon/bulbasaur"));

        HttpResponse execute = httpClient.execute(get);

        InputStream in = execute.getEntity().getContent();
        BufferedReader rd = new BufferedReader(new InputStreamReader(in));
        String line;
        StringBuilder responsePayload = new StringBuilder();
        while ((line = rd.readLine()) != null) {
            responsePayload.append(line);
        }

        String responseAsString = responsePayload.toString();

        System.out.println(responseAsString);

    }
}
