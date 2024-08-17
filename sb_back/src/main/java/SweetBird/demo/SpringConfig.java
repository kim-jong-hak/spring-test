package SweetBird.demo;

import SweetBird.demo.Repository.mapRepository;
import SweetBird.demo.servics.sevice;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    @Bean
    public sevice service( )
    {
        return new sevice(Spring_Repository());
    }

    @Bean
    public mapRepository Spring_Repository()
    {
        return new mapRepository();
    }
}
