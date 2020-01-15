package kunshan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//http://127.0.0.1:8761/
@SpringBootApplication
public class EurekaClientApplication {
    public static void main(String[] args){
        SpringApplication.run(EurekaClientApplication.class,args);

    }
}
