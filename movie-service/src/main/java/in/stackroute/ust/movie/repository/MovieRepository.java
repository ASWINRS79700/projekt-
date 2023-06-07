package in.stackroute.ust.movie.repository;

import in.stackroute.ust.movie.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie,Integer> {
    public Optional<Movie> getMovieByTitle(String title);
}
