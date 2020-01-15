package ytb.common;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import ytb.common.basic.safecontext.rest.RestSysLoginSso;
import ytb.common.test.CorsConfig;
import ytb.common.test.rest.RestDemo;

@SpringBootApplication
@ImportResource({"classpath:AppContextCommon.xml"})
public class SpringBootCommon {
    public static void main(String[] args) {

        SpringApplication.run(new Class[]{
                CorsConfig.class,
                SpringBootCommon.class,
                RestSysLoginSso.class,
                RestDemo.class}, args);

    }
}


