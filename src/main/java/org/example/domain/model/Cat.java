package org.example.domain.model;

import jakarta.annotation.PostConstruct;
import org.jspecify.annotations.NonNull;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;

public class Cat implements InitializingBean, BeanFactoryAware, DisposableBean {
    private CatLover catLover;

    public Cat() {
        System.out.println("Cat - constructor");
    }

    @PostConstruct
    private void initViaPostConstruct() {
        System.out.println("Cat - init via @PostConstruct");
    }

    public void initViaBeanConfig() {
        System.out.println("Cat - init via @Bean in config class");
    }

    @Autowired
    public void setCatLover(CatLover catLover) {
        System.out.println("Cat - setCatLover()");
        this.catLover = catLover;
    }

    public void sayHello() {
        System.out.println("Meow~~~ " + (Objects.nonNull(catLover)? catLover.name():""));
    }

    /**
     * This method allows the bean instance to perform validation of its overall
     * configuration and final initialization when all bean properties have been set.
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Cat - afterPropertiesSet() in InitializingBean interface");
    }

    @Override
    public void setBeanFactory(@NonNull BeanFactory beanFactory) throws BeansException {
        System.out.println("Cat - setBeanFactory() in BeanFactoryAware interface");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Cat - destroy() in DisposableBean");
    }

    public void destroyViaBeanConfig() {
        System.out.println("Cat - destroyViaBeanConfig() @Bean in config class");
    }
}
