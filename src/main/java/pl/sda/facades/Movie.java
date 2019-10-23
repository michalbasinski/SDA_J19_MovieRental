package pl.sda.facades.Movie;

public class Movie {
    private String title;
    private String director;
    private Integer makeYear;
    private Integer id;
    private Integer price;

    public Movie(String title, String director, Integer makeYear, Integer id, Integer price) {
        this.title = title;
        this.director = director;
        this.makeYear = makeYear;
        this.id = id;
        this.price = price;
    }

    public Movie() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Integer getMakeYear() {
        return makeYear;
    }

    public void setMakeYear(Integer makeYear) {
        this.makeYear = makeYear;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
