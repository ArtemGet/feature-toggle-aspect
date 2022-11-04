package artemget.featuretoggle.aspect;

import artemget.featuretoggle.feature.FeatureContainer;

public abstract class AbstractToggleCommandFactory<J> {
    public abstract AbstractToggleCommand<J, ?> create(FeatureContainer featureManager);
}
