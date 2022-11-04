package artemget.featuretoggle.feature;

import java.util.Objects;

/**
 * Feature
 */
public class Feature {
    private final String featureName;
    private boolean disabled;

    public Feature(String featureName, boolean disabled) throws NullPointerException {
        Objects.requireNonNull(featureName);
        this.featureName = featureName;
        this.disabled = disabled;
    }

    void toggle(boolean disabled) {
        this.disabled = disabled;
    }

    public String getFeatureName() {
        return featureName;
    }

    public boolean isDisabled() {
        return disabled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Feature)) return false;
        Feature feature = (Feature) o;
        return isDisabled() == feature.isDisabled() && Objects.equals(getFeatureName(), feature.getFeatureName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFeatureName(), isDisabled());
    }
}
