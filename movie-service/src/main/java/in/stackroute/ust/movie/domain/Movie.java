package in.stackroute.ust.movie.domain;

import javax.persistence.*;

@Entity
@Table(name="movies")
public class Movie {
    @Id
    @GeneratedValue
    private int id;

    @Column(unique = true)
    private String title;

    public Movie() {
    }

    public Movie(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
