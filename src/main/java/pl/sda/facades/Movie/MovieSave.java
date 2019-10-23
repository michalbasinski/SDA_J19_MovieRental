package pl.sda.facades.Movie;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class MovieSave {

    void adToDB(List<Movie> movies, String filePath) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath))) {

            String headerRow = "title;director;makeYear;id";
            bufferedWriter.write(headerRow);
            bufferedWriter.newLine();

            StringBuilder stringBuilder = new StringBuilder();
            for (Movie movie : movies) {
                stringBuilder.setLength(0);
                stringBuilder.append(movie.getTitle()).append(";")
                        .append(movie.getDirector()).append(";")
                        .append(movie.getMakeYear()).append(";")
                        .append(movie.getId());
                bufferedWriter.write(stringBuilder.toString());
                bufferedWriter.newLine();
            }
            bufferedWriter.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
