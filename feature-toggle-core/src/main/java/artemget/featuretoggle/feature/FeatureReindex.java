package artemget.featuretoggle.feature;

import java.util.Set;

public interface FeatureReindex {

    /**
     * Reindex all features, NPE in case of features null input or is empty or any
     * feature is null or featureName is null
     *
     * @param features - features
     */
    void reindex(Set<Feature> features) throws NullPointerException;

    /**
     * Toggle feature, NPE in case of feature is null or featureName is null
     *
     * @param feature - features
     */
    void toggle(Feature feature) throws NullPointerException;

    /**
     * Toggle features, NPE in case of features null
     *
     * @param features - features
     */
    void toggle(Set<Feature> features) throws NullPointerException;
}
