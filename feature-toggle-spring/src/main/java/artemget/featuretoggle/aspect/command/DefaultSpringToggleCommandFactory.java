package artemget.featuretoggle.aspect.command;

import artemget.featuretoggle.annotation.ToggleFeature;
import artemget.featuretoggle.annotation.ToggleFeatures;
import artemget.featuretoggle.feature.FeatureContainer;
import org.aspectj.lang.JoinPoint;

public class DefaultSpringToggleCommandFactory extends AbstractToggleCommandFactory<JoinPoint> {

    @Override
    public AbstractToggleCommand<JoinPoint, ToggleFeatures> create(FeatureContainer featureContainer) {
        SingleFeatureCommand singleFeatureProcessorStrategy =
                new SingleFeatureCommand(ToggleFeature.class,
                        new TrailingToggleCommand<>(),
                        featureContainer);

        return new MultipleFeatureCommand(ToggleFeatures.class,
                singleFeatureProcessorStrategy,
                featureContainer);
    }
}
