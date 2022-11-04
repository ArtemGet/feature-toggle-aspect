package artemget.featuretoggle.feature;

import java.util.Set;

public interface FeatureReindex {

    /**
     * Reindex all features, NPE in case of features null
     *
     * @param features - features
     */
    void reindex(Set<Feature> features) throws NullPointerException;

    /**
     * Toggle feature, NPE in case of features null
     *
     * @param features - features
     */
    void toggle(Feature features) throws NullPointerException;

    /**
     * Toggle features, NPE in case of features null
     *
     * @param features - features
     */
    void toggle(Set<Feature> features) throws NullPointerException;
}
