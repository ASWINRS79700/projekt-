package in.stackroute.ust.service;

import com.netflix.discovery.converters.Auto;
import in.stackroute.ust.dto.CustomerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;
@Service


public class CustomerServiceImpl implements CustomerService{
    @Autowired
    RestTemplate restTemplate;
    public String url="http://localhost:8080/api/v1/customers/email/{email}";
    @Override
    public Optional<CustomerDto> findByEmail(String email) {
        try {
            var res=restTemplate.getForEntity(url,CustomerDto.class,email);
            if(res.getStatusCode().is2xxSuccessful()){
            return Optional.ofNullable(res.getBody());
            }return Optional.empty();
        }
        catch (Exception e){
            return Optional.empty();
        }

    }
}
