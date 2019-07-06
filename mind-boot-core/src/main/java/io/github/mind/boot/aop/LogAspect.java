package io.github.mind.boot.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
@Slf4j
public class LogAspect {

    @Around("bean(*ServiceImpl)")
    public Object handleControllerMethod(ProceedingJoinPoint pjp) throws Throwable {
        String className = pjp.getTarget().getClass().getSimpleName();
        String methodName = pjp.getSignature().getName();
        Object[] args = pjp.getArgs();

        StringBuilder methodStartInfo = new StringBuilder();
        methodStartInfo.append(className)
                .append(" ")
                .append(methodName)
                .append(" ");
        if (args != null && args.length > 0) {
            methodStartInfo.append("start, params:");
            for (Object arg : args) {
                methodStartInfo.append(arg.toString()).append(" ");
            }
        } else {
            methodStartInfo.append("start.");
        }
        log.info(methodStartInfo.toString());
        Object obj = pjp.proceed();
        String methodEndInfo = className + " " + methodName + " end.";
        log.info(methodEndInfo);
        return obj;
    }
}
