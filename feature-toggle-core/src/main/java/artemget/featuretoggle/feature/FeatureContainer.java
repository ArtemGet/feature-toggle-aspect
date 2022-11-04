package artemget.featuretoggle.feature;

public interface FeatureContainer {

    /**
     * Provides feature, NPE in case of nothing found
     *
     * @param featureName - feature name
     * @return feature
     */
    Feature getFeature(String featureName) throws NullPointerException;
}
