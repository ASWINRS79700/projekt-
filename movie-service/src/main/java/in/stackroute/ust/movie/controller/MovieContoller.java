package in.stackroute.ust.movie.controller;

import in.stackroute.ust.movie.domain.Movie;
import in.stackroute.ust.movie.dto.MovieDto;
import in.stackroute.ust.movie.service.MovieServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/movies")

public class MovieContoller {

    MovieServiceImpl movieService;
    public MovieContoller(MovieServiceImpl movieService) {
        this.movieService=movieService;
    }
    private Logger logger = LoggerFactory.getLogger(MovieContoller.class);

    MovieDto createDto(Movie c){
        MovieDto movieDto=new MovieDto(c.getId(), c.getTitle());
        return movieDto;
    }
    Movie createCustomer(MovieDto c)
    {
        Movie customer=new Movie(c.id(), c.title());
        return customer;
    }

    @PostMapping("")
    public ResponseEntity<?> Save( @RequestBody MovieDto cc){
        var c=createCustomer(cc);
        logger.info("Customer Entity: {}", c);
        movieService.save(c);
        logger.info("Customer added:{}", c);

        return ResponseEntity.status(HttpStatus.CREATED).body(c);
    }
    @GetMapping("/{id}")
    public  ResponseEntity<?> getById(@PathVariable int id){
        return ResponseEntity.status(HttpStatus.FOUND).body(createDto(movieService.getById(id)));
    }
    @GetMapping("/title/{title}")
    public  ResponseEntity<?> getByEmail(@PathVariable String title){
        return ResponseEntity.status(HttpStatus.FOUND).body(createDto(movieService.getMovieByTitle(title)));
    }
    @GetMapping("")
    public ResponseEntity<List<MovieDto>> getAll(){
        List<MovieDto> ll=movieService.getAll().stream().map(customer -> createDto(customer)).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.FOUND).body(ll);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        movieService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @PutMapping("")
    public  ResponseEntity<?>update( @RequestBody MovieDto cc){
        var c=createCustomer(cc);
        movieService.update(c);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
