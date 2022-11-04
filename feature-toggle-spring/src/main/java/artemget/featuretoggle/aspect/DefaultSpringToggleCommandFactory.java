package artemget.featuretoggle.aspect;

import artemget.featuretoggle.annotation.ToggleFeature;
import artemget.featuretoggle.annotation.ToggleFeatures;
import artemget.featuretoggle.feature.FeatureContainer;
import org.aspectj.lang.JoinPoint;

public class DefaultSpringToggleCommandFactory extends AbstractToggleCommandFactory<JoinPoint> {

    @Override
    public AbstractToggleCommand<JoinPoint, ToggleFeatures> create(FeatureContainer featureContainer) {
        SingleToggleCommand singleFeatureProcessorStrategy =
                new SingleToggleCommand(ToggleFeature.class,
                        new TrailingToggleCommand<>(),
                        featureContainer);

        return new MultipleToggleCommand(ToggleFeatures.class,
                singleFeatureProcessorStrategy,
                featureContainer);
    }
}
