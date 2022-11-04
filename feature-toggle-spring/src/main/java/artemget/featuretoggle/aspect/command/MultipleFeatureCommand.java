package artemget.featuretoggle.aspect.command;

import artemget.featuretoggle.annotation.ToggleFeatures;
import artemget.featuretoggle.feature.FeatureContainer;
import org.aspectj.lang.JoinPoint;

public class MultipleFeatureCommand extends AbstractToggleCommand<JoinPoint, ToggleFeatures> {

    public MultipleFeatureCommand(Class<ToggleFeatures> target_annotation,
                                  AbstractToggleCommand<JoinPoint, ?> nextProcessor,
                                  FeatureContainer featureContainer) {
        super(nextProcessor, target_annotation, featureContainer);
    }

    @Override
    public void processFeatureToggle(JoinPoint joinPoint) {

    }

    @Override
    protected ToggleFeatures ejectAnnotation(JoinPoint joinPoint) {
        return null;
    }
}
