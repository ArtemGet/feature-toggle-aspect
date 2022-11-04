package artemget.featuretoggle.aspect.command;

import artemget.featuretoggle.annotation.ToggleFeature;
import artemget.featuretoggle.feature.FeatureContainer;
import org.aspectj.lang.JoinPoint;

public class SingleFeatureCommand extends AbstractToggleCommand<JoinPoint, ToggleFeature> {
    public SingleFeatureCommand(Class<ToggleFeature> target_annotation,
                                AbstractToggleCommand<JoinPoint, ?> nextProcessor,
                                FeatureContainer featureContainer) {
        super(nextProcessor, target_annotation, featureContainer);
    }

    @Override
    protected ToggleFeature ejectAnnotation(JoinPoint joinPoint) {
        return null;
    }

    @Override
    public void processFeatureToggle(JoinPoint joinPoint) {

    }
}
