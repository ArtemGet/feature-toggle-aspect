package artemget.featuretoggle.aspect;

import artemget.featuretoggle.exception.FeatureDisabledException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.lang.annotation.Annotation;

@Aspect
public class SpringFeatureToggleAspect extends AbstractToggleAspect<JoinPoint> implements TogglePoint {

    public SpringFeatureToggleAspect(SpringToggleChain<JoinPoint, ? extends Annotation> toggleCommand) {
        super(toggleCommand);
    }

    @Override
    @Pointcut("execution(* (@artemget.featuretoggle.annotation.ToggleFeature *).*(..)) ||" +
            " execution(* (@artemget.featuretoggle.annotation.ToggleFeatures *).*(..))")
    public void classLayerPointcut() {
    }

    @Override
    @Pointcut("@annotation(artemget.featuretoggle.annotation.ToggleFeature) || " +
            "@annotation(artemget.featuretoggle.annotation.ToggleFeatures)")
    public void methodLayerPointcut() {
    }

    @Override
    @Before("classLayerPointcut() || methodLayerPointcut()")
    public void processFeatureToggle(JoinPoint joinPoint)  throws FeatureDisabledException {
        toggleCommand.processFeatureToggle(joinPoint);
    }
}
