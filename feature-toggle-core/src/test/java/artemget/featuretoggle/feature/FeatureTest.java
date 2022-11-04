package artemget.featuretoggle.feature;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FeatureTest {

    @Test
    public void constructor_shouldFail_nullFeatureName() {
        String featureName = null;
        boolean disabled = false;

        Assertions.assertThrows(NullPointerException.class,
                () -> new Feature(featureName, disabled));
    }
}