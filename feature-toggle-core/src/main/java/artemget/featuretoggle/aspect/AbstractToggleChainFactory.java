package artemget.featuretoggle.aspect;

import artemget.featuretoggle.feature.FeatureContainer;

public abstract class AbstractToggleChainFactory<J> {
    public abstract AbstractToggleChain<J, ?> create(FeatureContainer featureManager);
}
