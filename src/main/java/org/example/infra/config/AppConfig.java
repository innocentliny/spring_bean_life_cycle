package org.example.infra.config;

import org.example.domain.model.Cat;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public static BeanFactoryPostProcessor beanFactoryPostProcessor() { // 使用 static 是為了讓這類的 bean processor 優先於其他 bean。
        return new MyBeanFactoryPostProcessor();
    }

    @Bean
    public static BeanPostProcessor beanPostProcessor() { // 使用 static 是為了讓這類的 bean processor 優先於其他 bean。
        return new MyBeanPostProcessor();
    }

    @Bean(initMethod = "initViaBeanConfig", destroyMethod = "destroyViaBeanConfig")
    public Cat cat() {
        return new Cat();
    }
}
