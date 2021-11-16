package curso.springboot.springboot;

import java.util.TimeZone;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EntityScan(basePackages = "curso.springboot.model")
// Força o mapeamento de todos os pacotes que começam com curso.
@ComponentScan(basePackages = {"curso.*"})
// Ativando recursos do JPA
@EnableJpaRepositories(basePackages = {"curso.springboot.repository"})
@EnableTransactionManagement
public class SpringbootApplication {
    
    public static void main(String[] args) {
        TimeZone.setDefault(TimeZone.getTimeZone("UMC - 03:00"));
        SpringApplication.run(SpringbootApplication.class, args);
    }
    
}
