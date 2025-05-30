package 项目实战.movie;

public class Movie {
    private String id;
    private String name;
    private String type;
    private double rating;

    public Movie(String id, String name, String type, double rating) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.rating = rating;
    }

    public Movie() {
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id + ' ' +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", rating=" + rating +
                '}';
    }
}