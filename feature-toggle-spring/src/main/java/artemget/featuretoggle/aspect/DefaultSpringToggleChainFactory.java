package artemget.featuretoggle.aspect;

import artemget.featuretoggle.annotation.ToggleFeature;
import artemget.featuretoggle.annotation.ToggleFeatures;
import artemget.featuretoggle.feature.FeatureContainer;
import org.aspectj.lang.JoinPoint;

/**
 * Default spring toggle chain factory
 */
public class DefaultSpringToggleChainFactory extends AbstractToggleChainFactory<JoinPoint> {

    /**
     * Create nested toggle chains for default spring annotation processing
     *
     * @param featureContainer - feature container
     * @return MultipleToggleChain
     */
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
