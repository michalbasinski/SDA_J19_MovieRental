package pl.sda.facades.Movie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieSaveAdapter {

    public List<Map<String, Object>> movieListToMap (List<Movie> movies) {
            List<Map<String, Object>> result = new ArrayList<>();

            for (Movie movie: movies) {
                Map<String, Object> temp = new HashMap<>();
                temp.put("title", movie.getTitle());
                temp.put("director", movie.getDirector());
                temp.put("makeYear", movie.getMakeYear());
                temp.put("id", movie.getId());
                temp.put("price", movie.getPrice());
                result.add(temp);
            }
            return result;
        }
}