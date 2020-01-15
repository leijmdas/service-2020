package ytb.project;


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
// "classpath:AppContextProject.xml",
//.../actuator/beans
@EnableSwagger2
@SpringBootApplication(scanBasePackages = "ytb")
@ImportResource({"classpath:AppContextCommon.xml"})
public class ProjectApp {

    public static void main(String[] args) {
        SpringApplication.run(new Class[]{CorsConfig.class,
                ProjectApp.class}, args);

    }


}
