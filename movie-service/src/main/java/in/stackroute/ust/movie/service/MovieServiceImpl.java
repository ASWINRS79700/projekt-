package in.stackroute.ust.movie.service;

import in.stackroute.ust.movie.domain.Movie;
import in.stackroute.ust.movie.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class MovieServiceImpl implements MovieService{
    @Autowired
    MovieRepository movieRepository;
    @Override
    public void save(Movie c) {
        movieRepository.save(c);
    }
    @Override
    public Movie getMovieByTitle(String title){

        return movieRepository.getMovieByTitle(title).get();
    };
    @Override
    public Movie getById(int c) {
        return movieRepository.findById(c).get();
    }

    @Override
    public List<Movie> getAll() {
        return movieRepository.findAll();
    }

    @Override
    public void delete(int id) {
        movieRepository.deleteById(id);
    }

    @Override
    public void update(Movie c) {
    movieRepository.save(c);
    }
}
