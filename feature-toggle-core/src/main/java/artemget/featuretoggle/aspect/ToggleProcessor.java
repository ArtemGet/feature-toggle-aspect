package artemget.featuretoggle.aspect;

import artemget.featuretoggle.exception.FeatureDisabledException;

public interface ToggleProcessor<J> {
    /**
     * Annotation processing
     *
     * @param joinPoint - join point
     */
    void processFeatureToggle(J joinPoint) throws FeatureDisabledException;
}
