package artemget.featuretoggle.feature;

import artemget.featuretoggle.exception.FeatureNotFoundEx;
import artemget.featuretoggle.exception.errorCode.ErrorCodeTemplate;

import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * feature toggle management
 */
//TODO: singleton
public class FeatureManager implements FeatureReindex, FeatureContainer {
    //TODO: concurrentMap
    private Map<String, Feature> featureMap;

    /**
     * NPE in case of features null input or is empty or any
     * feature is null or featureName is null
     *
     * @param features - features
     */
    public FeatureManager(Set<Feature> features) {
        Objects.requireNonNull(features);
        if (features.isEmpty()) {
            throw new NullPointerException("Empty feature set");
        }
        this.featureMap = toMap(features);
    }

    @Override
    synchronized public Feature getFeature(String featureName) {
        Objects.requireNonNull(featureName);
        Feature feature = featureMap.get(featureName);
        if (feature == null) {
            String errorMessage = String.format(ErrorCodeTemplate.FEATURE_NOT_FOUND, featureName);
            throw new FeatureNotFoundEx(errorMessage);
        }
        return feature;
    }

    @Override
    synchronized public void reindex(Set<Feature> features) {
        Objects.requireNonNull(features);
        if (features.isEmpty()) {
            throw new NullPointerException();
        }
        this.featureMap = toMap(features);
    }

    @Override
    synchronized public void toggle(Set<Feature> features) {
        Objects.requireNonNull(features);
        features.forEach(this::toggleFeature);
    }

    @Override
    synchronized public void toggle(Feature feature) {
        Objects.requireNonNull(feature);
        Objects.requireNonNull(feature.getFeatureName());
        this.toggleFeature(feature);
    }

    private Map<String, Feature> toMap(Set<Feature> features) {
        return features.stream()
                .peek(feature -> {
                    if (feature == null || feature.getFeatureName() == null) {
                        throw new NullPointerException("Feature is null or featureName is null");
                    }
                })
                .collect(Collectors.toMap(Feature::getFeatureName, feature -> feature));
    }

    private void toggleFeature(Feature feature) {
        Feature featureToToggle = featureMap.get(feature.getFeatureName());
        if (featureToToggle == null) {
            String errorMessage = String.format(ErrorCodeTemplate.FEATURE_NOT_FOUND, feature.getFeatureName());
            throw new FeatureNotFoundEx(errorMessage);
        }

        featureToToggle.toggle(feature.isDisabled());
    }
}
