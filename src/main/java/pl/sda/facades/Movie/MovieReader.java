package pl.sda.facades.Movie;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Handler;

public class MovieReader {

    List<Movie> readMovieDB(String filePath) {
        List<Movie> result = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String headerRow = bufferedReader.readLine();
            String[] headers = headerRow.split(";");

            String record;
            while ((record = bufferedReader.readLine()) != null) {
                String[] tokens = record.split(";");
                Movie movie = createMovie(headers, tokens);
                result.add(movie);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    private Movie createMovie(String[] headers, String[] tokens) {
        Movie movie = new Movie();
        for (int i = 0; i < headers.length; i++) {
            if ("director".equals(headers[i])) {
                movie.setDirector(tokens[i]);
            }
            if ("makeYear".equals(headers[i])) {
                movie.setMakeYear(Integer.valueOf(tokens[i]));
            }
            if ("id".equals(headers[i])) {
                movie.setId(Integer.valueOf(tokens[i]));
            }
            if ("title".equals(headers[i])) {
                movie.setTitle(tokens[i]);
            }
            if ("price".equals(headers[i])) {
                movie.setPrice(Integer.valueOf(tokens[i]));
            }
        } return movie;
    }
}