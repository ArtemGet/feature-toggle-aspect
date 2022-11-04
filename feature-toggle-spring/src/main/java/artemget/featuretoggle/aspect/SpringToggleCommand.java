package artemget.featuretoggle.aspect;

import artemget.featuretoggle.feature.FeatureContainer;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public abstract class SpringToggleCommand<J extends JoinPoint, A extends Annotation> extends AbstractToggleCommand<J,A> {
    public SpringToggleCommand(AbstractToggleCommand<J, ?> nextProcessor,
                               Class<A> targetAnnotation,
                               FeatureContainer featureManager) {
        super(nextProcessor, targetAnnotation, featureManager);
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
}
