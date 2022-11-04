package artemget.featuretoggle.feature;

import artemget.featuretoggle.exception.FeatureNotFoundEx;
import artemget.featuretoggle.exception.errorCode.ErrorCodeTemplate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Set;

//TODO: concurrent tests
class FeatureManagerTest {

    @Test
    public void getFeature_shouldGet_featureNameExists() {
        Feature expected = new Feature("first", false);

        Set<Feature> features = Set.of(expected);
        FeatureContainer container = new FeatureManager(features);

        String featureName = "first";
        Feature actual = container.getFeature(featureName);

        Assertions.assertNotNull(actual);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void toggle_shouldThrow_featureNotExists() {
        Set<Feature> features = Set.of(new Feature("first", false));
        FeatureReindex featureManager = new FeatureManager(features);

        String expectedErrorMessage = String
                .format(ErrorCodeTemplate.FEATURE_NOT_FOUND, "first");

        Assertions.assertThrows(FeatureNotFoundEx.class,
                () -> featureManager.toggle(new Feature("second", true)),
                expectedErrorMessage);
    }

    @Test
    public void toggle_shouldToggle_featureExists() {
        Set<Feature> features = Set.of(new Feature("first", false));
        FeatureManager featureManager = new FeatureManager(features);

        featureManager.toggle(new Feature("first", true));

        Assertions.assertTrue(featureManager.getFeature("first").isDisabled());
    }

    @Test
    public void reindex_shouldReindex_inputNotNull() {
        Set<Feature> features = Set.of(new Feature("first", false));
        FeatureManager featureManager = new FeatureManager(features);

        Feature expected = new Feature("second", false);
        featureManager.reindex(Set.of(expected));

        Feature actual = featureManager.getFeature("second");

        Assertions.assertEquals(expected, actual);
        Assertions.assertNull(featureManager.getFeature("first"));
    }

    //Input tests

    @Test
    public void constructor_shouldNpe_inputNull() {
        Set<Feature> features = null;
        Assertions.assertThrows(NullPointerException.class,
                () -> new FeatureManager(features));
    }

    @Test
    public void constructor_shouldNpe_inputEmty() {
        Set<Feature> features = Set.of();
        Assertions.assertThrows(NullPointerException.class,
                () -> new FeatureManager(features));
    }

    @Test
    public void reindex_shouldNpe_inputNull() {
        Set<Feature> features = Set.of(new Feature("first", false));
        FeatureReindex reindexManager = new FeatureManager(features);

        Set<Feature> reindexFeatures = null;
        Assertions.assertThrows(NullPointerException.class,
                () -> reindexManager.reindex(reindexFeatures));
    }

    @Test
    public void reindex_shouldNpe_inputEmpty() {
        Set<Feature> features = Set.of(new Feature("first", false));
        FeatureReindex reindexManager = new FeatureManager(features);

        Set<Feature> reindexFeatures = Set.of();
        Assertions.assertThrows(NullPointerException.class,
                () -> reindexManager.reindex(reindexFeatures));
    }

    @Test
    public void toggleSet_shouldNpe_inputNull() {
        Set<Feature> features = Set.of(new Feature("first", false));
        FeatureReindex reindexManager = new FeatureManager(features);

        Set<Feature> toggleFeatures = null;
        Assertions.assertThrows(NullPointerException.class,
                () -> reindexManager.toggle(toggleFeatures));
    }

    @Test
    public void toggle_shouldNpe_inputNull() {
        Set<Feature> features = Set.of(new Feature("first", false));
        FeatureReindex reindexManager = new FeatureManager(features);

        Feature toggleFeature = null;
        Assertions.assertThrows(NullPointerException.class,
                () -> reindexManager.toggle(toggleFeature));
    }

    @Test
    public void getFeature_shouldNpe_inputNull() {
        Set<Feature> features = Set.of(new Feature("first", false));
        FeatureContainer container = new FeatureManager(features);

        String featureName = null;
        Assertions.assertThrows(NullPointerException.class,
                () -> container.getFeature(featureName));
    }
}