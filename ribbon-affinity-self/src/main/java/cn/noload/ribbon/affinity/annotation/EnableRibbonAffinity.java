package cn.noload.ribbon.affinity.annotation;

import cn.noload.ribbon.affinity.RibbonAffinitySelfBeanFactoryPostProcessor;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author hao.caosh@ttpai.cn
 * @date 2020-03-17 14:32
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(RibbonAffinitySelfBeanFactoryPostProcessor.class)
public @interface EnableRibbonAffinity {
}
