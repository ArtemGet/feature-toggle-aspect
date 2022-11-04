package artemget.featuretoggle.feature;

public interface FeatureContainer {

    /**
     * Provides feature
     *
     * @param featureName - feature name
     * @return feature
     */
    Feature getFeature(String featureName);
}
