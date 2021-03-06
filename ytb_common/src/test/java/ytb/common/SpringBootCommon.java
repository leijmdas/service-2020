package ytb.common;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableAsync;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication(scanBasePackages = {"ytb"})
@EnableSwagger2
@ImportResource({"classpath:AppContextCommon.xml"})
@EnableAsync
public class SpringBootCommon {
    public static void main(String[] args) {

        SpringApplication.run(new Class[]{
                SpringBootCommon.class }, args);

    }
}


