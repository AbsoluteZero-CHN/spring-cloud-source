package cn.noload.consumer;

import cn.noload.ribbon.FirstRibbonConfiguration;
import cn.noload.ribbon.SecondRibbonConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;

@EnableEurekaClient
@SpringBootApplication
@RibbonClients({
        @RibbonClient(name = "SOURCE-PRODUCER-1", configuration = FirstRibbonConfiguration.class),
        @RibbonClient(name = "SOURCE-PRODUCER-2", configuration = SecondRibbonConfiguration.class)
})
public class ConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }

}
