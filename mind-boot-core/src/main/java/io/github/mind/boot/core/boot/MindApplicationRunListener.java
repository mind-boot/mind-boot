package io.github.mind.boot.core.boot;

import io.github.mind.boot.core.MindBootApplication;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.JavaVersion;
import org.apache.commons.lang3.SystemUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.Ordered;
import org.springframework.core.SpringVersion;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Objects;

/**
 * 运行监听器
 *
 * @author caoyong
 * @version 1.0.0
 * @since 2019-06-26 16:31:02
 **/
@Slf4j
@Order(Ordered.HIGHEST_PRECEDENCE)
public class MindApplicationRunListener implements SpringApplicationRunListener {
    public MindApplicationRunListener(SpringApplication springApplication, String[] args) {
        MindBootApplication annotation = null;
        for (Object source : springApplication.getSources()) {
            if (!(source instanceof Class)) {
                continue;
            }
            annotation = AnnotatedElementUtils.findMergedAnnotation((Class) source, MindBootApplication.class);
            if (annotation != null) {
                break;
            }
        }
        if (annotation == null) {
            log.warn("sources中无@MindBootApplication");
        }
        //Assert.notNull(annotation, "sources中无@MindBootApplication");
    }

    @Override
    public void starting() {
        if (!SystemUtils.isJavaVersionAtLeast(JavaVersion.JAVA_1_8)) {
            throw new IllegalStateException("请使用jdk1.8及以上版本");
        }
        if (Integer.parseInt(Objects.requireNonNull(SpringVersion.getVersion()).substring(0, 1)) < 4) {
            throw new IllegalStateException("请使用spring4.x版本");
        }
    }

    @Override
    public void environmentPrepared(ConfigurableEnvironment environment) {

    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {

    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {

    }

    @Override
    public void started(ConfigurableApplicationContext context) {

    }

    @Override
    public void running(ConfigurableApplicationContext context) {

    }

    @Override
    public void failed(ConfigurableApplicationContext context, Throwable exception) {

    }
}
