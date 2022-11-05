package artemget.featuretoggle.feature;

import artemget.featuretoggle.exception.FeatureNotFoundEx;

public interface FeatureContainer {

    /**
     * Provides feature, NPE in case of nothing found
     *
     * @param featureName - feature name
     * @return feature
     */
    Feature getFeature(String featureName) throws NullPointerException, FeatureNotFoundEx;
}
