package in.stackroute.ust.service;

import in.stackroute.ust.dto.MovieDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;
@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    private RestTemplate restTemplate;
    public static String url="http://localhost:8080/api/v1/movies/{id}";

    @Override
    public Optional<MovieDto> findById(int id) {

        try {
            final var res=restTemplate.getForEntity(url,MovieDto.class,id);
            if(res.getStatusCode().is2xxSuccessful()){
                return Optional.ofNullable(res.getBody());
            }
            return Optional.empty();
        }
        catch (Exception e){
            return Optional.empty();
        }
    }
}
