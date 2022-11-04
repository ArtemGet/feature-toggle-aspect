package artemget.featuretoggle.aspect;


import artemget.featuretoggle.feature.FeatureContainer;
import artemget.featuretoggle.feature.FeatureManager;

/**
 * Abstract feature toggle processor
 *
 * @param <J> - joinPoint, rely on realization
 */
public abstract class AbstractToggleAspect<J> {
    private final FeatureContainer featureManager;

    protected AbstractToggleAspect(FeatureManager featureManager) {
        this.featureManager = featureManager;
    }

    /**
     * Points where aspect should process on Class layer
     */
    public abstract void classLayerPointcut();

    /**
     * Points where aspect should process on method layer
     */
    public abstract void methodLayerPointcut();

    /**
     * Annotation processing
     *
     * @param joinPoint - join point
     */
    public abstract void processFeatureToggle(J joinPoint);
}
