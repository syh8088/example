package com.example.api.aspect;

import com.example.api.model.entities.point.Point;
import com.example.api.repositories.point.PointRepository;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

@Configuration
@Aspect
@Order(Ordered.HIGHEST_PRECEDENCE)
public class PointAspect {

    private final PointRepository pointRepository;

    @Autowired
    public PointAspect(PointRepository pointRepository) {
        this.pointRepository = pointRepository;
    }

    @Pointcut("execution(public * com.example.api.repositories..*MemberMapper.updateMemberPoint(..))")
    public void mapper() {
    }

    @Around("mapper()")
    public Object checkArgumentAndReturnObjectForEncryptAnnotationField(ProceedingJoinPoint joinPoint) throws Throwable {

        Object[] args = joinPoint.getArgs();

        for (int i = 0; i < args.length; i++) {
            int tempI = i;
            setPoint((Point) args[tempI]);
        }

        return joinPoint.proceed(args);
    }

    private void setPoint(Point point) {
        pointRepository.save(point);
    }
}
