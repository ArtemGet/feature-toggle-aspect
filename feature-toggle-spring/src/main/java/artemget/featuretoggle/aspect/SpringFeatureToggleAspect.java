package artemget.featuretoggle.aspect;

import artemget.featuretoggle.aspect.command.AbstractToggleCommand;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class SpringFeatureToggleAspect extends AbstractToggleAspect<JoinPoint> implements TogglePoint {

    protected SpringFeatureToggleAspect(AbstractToggleCommand<JoinPoint, ?> toggleCommand) {
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
    public void processFeatureToggle(JoinPoint joinPoint) {
        toggleCommand.processFeatureToggle(joinPoint);
    }
}
