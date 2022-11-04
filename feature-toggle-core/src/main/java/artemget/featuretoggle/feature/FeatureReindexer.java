package artemget.featuretoggle.feature;

public interface FeatureReindexer {

    /**
     * Reindex all features
     *
     * @param features - features
     */
    void reindex(Feature... features);

    /**
     * Toggle features
     *
     * @param features - features
     */
    void toggle(Feature... features);
}
