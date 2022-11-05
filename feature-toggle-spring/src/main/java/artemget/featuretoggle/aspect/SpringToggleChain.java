package artemget.featuretoggle.aspect;

import artemget.featuretoggle.exception.FeatureDisabledException;
import artemget.featuretoggle.feature.FeatureContainer;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * Base spring feature toggle chain
 */
public abstract class SpringToggleChain<J extends JoinPoint, A extends Annotation>
        extends AbstractToggleChain<J, A> {
    public SpringToggleChain(AbstractToggleChain<J, ?> nextProcessor,
                             Class<A> targetAnnotation,
                             FeatureContainer featureContainer) {
        super(nextProcessor, targetAnnotation, featureContainer);
    }

    @Override
    protected A ejectAnnotation(J joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();

        A annotation = method.getAnnotation(TARGET_ANNOTATION);
        if (annotation == null) {
            Class<?> declaringClass = method.getDeclaringClass();
            annotation = declaringClass.getAnnotation(TARGET_ANNOTATION);
        }

        return annotation;
    }

    /**
     * Resolve actions - pass, break(throw) or pass to next processor, according to condition
     *
     * @param condition     - condition, if true - pass to next processor or trow
     * @param nextProcessor - next processor
     * @param joinPoint     - generic join point
     * @throws FeatureDisabledException - ex
     */
    protected void nextOrThrowOrPass(boolean condition,
                                     AbstractToggleChain<J, ?> nextProcessor,
                                     J joinPoint) throws FeatureDisabledException {
        if (condition) {
            if (nextProcessor != null) {
                nextProcessor.processFeatureToggle(joinPoint);
            }
            throw new FeatureDisabledException();
        }
    }
}
