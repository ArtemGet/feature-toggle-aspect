package artemget.featuretoggle.feature;

import artemget.featuretoggle.exception.FeatureNotFoundEx;
import artemget.featuretoggle.exception.errorCode.ErrorCodeTemplate;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * feature toggle management
 */
public class FeatureManager implements FeatureReindexer, FeatureContainer {
    private Map<String, Feature> featureMap;

    protected FeatureManager(Feature... features) {
        Objects.requireNonNull(features);
        this.featureMap = toMap(features);
    }

    @Override
    public Feature getFeature(String featureName) {
        Objects.requireNonNull(featureName);
        return featureMap.get(featureName);
    }

    @Override
    synchronized public void reindex(Feature... features) {
        Objects.requireNonNull(features);
        this.featureMap = toMap(features);
    }

    @Override
    synchronized public void toggle(Feature... features) {
        Objects.requireNonNull(features);
        Arrays.stream(features)
                .forEach(this::toggle);
    }

    private Map<String, Feature> toMap(Feature... features) {
        return Arrays.stream(features)
                .collect(Collectors.toMap(Feature::getFeatureName, feature -> feature));
    }

    private void toggle(Feature feature) {
        Feature featureToToggle = featureMap.get(feature.getFeatureName());
        if (featureToToggle == null) {
            String errorMessage = String.format(ErrorCodeTemplate.FEATURE_NOT_FOUND, feature.getFeatureName());
            throw new FeatureNotFoundEx(errorMessage);
        }

        featureToToggle.toggle(feature.isDisabled());
    }
}
