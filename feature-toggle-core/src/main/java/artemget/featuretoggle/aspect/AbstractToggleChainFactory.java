package artemget.featuretoggle.aspect;

import artemget.featuretoggle.feature.FeatureContainer;

/**
 * Base toggle chain factory
 *
 * @param <J> generic join point
 */
public abstract class AbstractToggleChainFactory<J> {

    /**
     * Provides base feature toggle chain element
     *
     * @param featureContainer - feature container
     * @return base feature toggle chain
     */
    public abstract AbstractToggleChain<J, ?> create(FeatureContainer featureContainer);
}
