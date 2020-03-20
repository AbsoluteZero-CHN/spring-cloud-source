package cn.noload.ribbon;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.Server;
import com.netflix.loadbalancer.ZoneAvoidanceRule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.ribbon.PropertiesFactory;
import org.springframework.cloud.netflix.ribbon.RibbonClientName;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * @author hao.caosh@ttpai.cn
 * @date 2020-03-18 10:30
 */
@Configuration
public class SecondRibbonConfiguration {

    @Resource
    private PropertiesFactory propertiesFactory;
    @Resource
    private IClientConfig iClientConfig;
    @RibbonClientName
    private String name = "client";


    @Bean
    public IRule iRule() {
        if (this.propertiesFactory.isSet(IRule.class, name)) {
            return this.propertiesFactory.get(IRule.class, iClientConfig, name);
        }
        ZoneAvoidanceRule rule = new ZoneAvoidanceRule();
        rule.initWithNiwsConfig(iClientConfig);
        return rule;
    }
}
