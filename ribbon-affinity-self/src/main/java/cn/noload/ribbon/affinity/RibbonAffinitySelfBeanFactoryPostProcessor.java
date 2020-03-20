package cn.noload.ribbon.affinity;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * @author hao.caosh@ttpai.cn
 * @date 2020-03-17 14:16
 */
public class RibbonAffinitySelfBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        beanFactory.getBeanDefinition("zoneAwareLoadBalancer");
    }
}
