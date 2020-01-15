package ytb.manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import ytb.common.test.CorsConfig;


/**
 * Package: PACKAGE_NAME
 * Author: ZCS
 * Date: Created in 2018/9/14 12:04
 */
@EnableSwagger2
@SpringBootApplication
@ImportResource({"classpath:AppContextCommon.xml"})
public class ManagerApp {
    public static void main(String[] args) {
        Class[] bootLst = new Class[]{
                CorsConfig.class,
                ManagerApp.class

        };
        SpringApplication.run(bootLst, args);
    }
}
