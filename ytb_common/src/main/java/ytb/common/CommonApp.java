package ytb.common;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import ytb.common.test.CorsConfig;

@SpringBootApplication(scanBasePackages = {"ytb.common"})
//@EnableSwagger2
@ImportResource({"classpath:AppContextCommon.xml"})
public class CommonApp {
    public static void main(String[] args) {

        SpringApplication.run(new Class[]{CorsConfig.class, CommonApp.class}, args);

    }
}


