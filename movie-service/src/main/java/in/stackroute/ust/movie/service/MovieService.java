package in.stackroute.ust.movie.service;

import in.stackroute.ust.movie.domain.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieService {
    void save(Movie c);
    Movie getById(int c);
    List<Movie> getAll();
    void delete(int id);
    void update(Movie c);
     Movie getMovieByTitle(String title);


}
