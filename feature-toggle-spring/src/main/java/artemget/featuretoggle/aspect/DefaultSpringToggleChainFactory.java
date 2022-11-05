package artemget.featuretoggle.aspect;

import artemget.featuretoggle.annotation.ToggleFeature;
import artemget.featuretoggle.annotation.ToggleFeatures;
import artemget.featuretoggle.feature.FeatureContainer;
import org.aspectj.lang.JoinPoint;

public class DefaultSpringToggleChainFactory extends AbstractToggleChainFactory<JoinPoint> {

    @Override
    public SpringToggleChain<JoinPoint, ToggleFeatures> create(FeatureContainer featureContainer) {
        SingleToggleChain singleFeatureProcessorStrategy =
                new SingleToggleChain(ToggleFeature.class,
                        null,
                        featureContainer);

        return new MultipleToggleChain(ToggleFeatures.class,
                singleFeatureProcessorStrategy,
                featureContainer);
    }
}
