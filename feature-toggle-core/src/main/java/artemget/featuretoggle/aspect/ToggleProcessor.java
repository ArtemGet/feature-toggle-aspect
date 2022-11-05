package artemget.featuretoggle.aspect;

import artemget.featuretoggle.exception.FeatureDisabledException;

/**
 * Feature toggle contract
 *
 * @param <J> - generic join point
 */
public interface ToggleProcessor<J> {
    /**
     * Annotation processing
     *
     * @param joinPoint - join point
     */
    void processFeatureToggle(J joinPoint) throws FeatureDisabledException;
}
