package lol.yi;

import com.example.EmbeddedAcmeService;
import com.example.MyService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
// Some conditions
public class MyAutoConfiguration {

    // Auto-configured beans

    @Configuration
    @ConditionalOnClass(EmbeddedAcmeService.class)
    static class EmbeddedConfiguration {

        @Bean
        @ConditionalOnMissingBean
        public EmbeddedAcmeService embeddedAcmeService() {
            return new EmbeddedAcmeService();
        }


    }

    @Configuration
    static class MyServiceConfiguration {


        @Bean
        @Primary
        @ConditionalOnMissingBean(MyService.class)
        public MyService myService() {

            return new MyService();
        }

    }




}
