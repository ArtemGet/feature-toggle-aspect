package artemget.featuretoggle.aspect;

import artemget.featuretoggle.annotation.ToggleFeatures;
import artemget.featuretoggle.feature.FeatureContainer;
import org.aspectj.lang.JoinPoint;

import java.lang.annotation.Annotation;

public class MultipleToggleCommand extends SpringToggleCommand<JoinPoint, ToggleFeatures> {

    public MultipleToggleCommand(Class<ToggleFeatures> targetAnnotation,
                                 AbstractToggleCommand<JoinPoint, ? extends Annotation> nextProcessor,
                                 FeatureContainer featureContainer) {
        super(nextProcessor, targetAnnotation, featureContainer);
    }

    @Override
    public void processFeatureToggle(JoinPoint joinPoint) {

    }
}
