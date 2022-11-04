package artemget.featuretoggle.aspect;

import artemget.featuretoggle.annotation.ToggleFeature;
import artemget.featuretoggle.feature.FeatureContainer;
import org.aspectj.lang.JoinPoint;

public class SingleToggleCommand extends SpringToggleCommand<JoinPoint, ToggleFeature> {

    public SingleToggleCommand(Class<ToggleFeature> targetAnnotation,
                               AbstractToggleCommand<JoinPoint, ?> nextProcessor,
                               FeatureContainer featureContainer) {
        super(nextProcessor, targetAnnotation, featureContainer);
    }

    @Override
    public void processFeatureToggle(JoinPoint joinPoint) {

    }
}
