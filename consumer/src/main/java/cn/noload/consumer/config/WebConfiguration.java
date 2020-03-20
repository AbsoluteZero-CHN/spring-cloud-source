package cn.noload.consumer.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestTemplate;

/**
 * @author hao.caosh@ttpai.cn
 * @date 2020-03-17 11:37
 */
@Configuration
public class WebConfiguration {

    @Bean
    @LoadBalanced
    @Qualifier("loadBalanced")
    public RestTemplate loadBalanced() {
        return new RestTemplate();
    }

    @Bean
    @Primary
    @Qualifier("restTemplate")
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
