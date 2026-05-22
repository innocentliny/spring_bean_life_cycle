package org.example.infra.config;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;

import java.util.Objects;

public class MyBeanPostProcessor implements InstantiationAwareBeanPostProcessor {
    @Override
    public @Nullable Object postProcessBeforeInitialization(@NonNull Object bean, @NonNull String beanName) throws BeansException {
        if (Objects.equals("cat", beanName)) {
            System.out.println("MyBeanPostProcessor - postProcessBeforeInitialization() " + beanName);
        }
        return InstantiationAwareBeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    @Override
    public @Nullable Object postProcessAfterInitialization(@NonNull Object bean, @NonNull String beanName) throws BeansException {
        if (Objects.equals("cat", beanName)) {
            System.out.println("MyBeanPostProcessor - postProcessAfterInitialization() " + beanName);
        }
        return InstantiationAwareBeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }

    @Override
    public @Nullable Object postProcessBeforeInstantiation(@NonNull Class<?> beanClass, @NonNull String beanName) throws BeansException {
        if (Objects.equals("cat", beanName)) {
            System.out.println("MyBeanPostProcessor - postProcessBeforeInstantiation() " + beanName);
        }
        return InstantiationAwareBeanPostProcessor.super.postProcessBeforeInstantiation(beanClass, beanName);
    }

    @Override
    public boolean postProcessAfterInstantiation(@NonNull Object bean, @NonNull String beanName) throws BeansException {
        if (Objects.equals("cat", beanName)) {
            System.out.println("MyBeanPostProcessor - postProcessAfterInstantiation() " + beanName);
        }
        return InstantiationAwareBeanPostProcessor.super.postProcessAfterInstantiation(bean, beanName);
    }

    @Override
    public @Nullable PropertyValues postProcessProperties(@NonNull PropertyValues pvs, @NonNull Object bean, @NonNull String beanName) throws BeansException {
        if (Objects.equals("cat", beanName)) {
            System.out.println("MyBeanPostProcessor - postProcessProperties() " + beanName + "(" + pvs + ")");
        }
        return InstantiationAwareBeanPostProcessor.super.postProcessProperties(pvs, bean, beanName);
    }
}
