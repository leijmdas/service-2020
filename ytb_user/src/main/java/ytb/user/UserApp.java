package ytb.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import ytb.common.test.CorsConfig;

/**
 * Package: PACKAGE_NAME
 * Author: ZCS
 * Date: Created in 2018/9/14 12:04
 */
@EnableSwagger2
@SpringBootApplication
public class UserApp {
    public static void main(String[] args) {
        SpringApplication.run(new Class[]
                {CorsConfig.class,UserApp.class}, args);

    }
}
