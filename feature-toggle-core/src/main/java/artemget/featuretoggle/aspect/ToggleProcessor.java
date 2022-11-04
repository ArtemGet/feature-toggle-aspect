package artemget.featuretoggle.aspect;

public interface ToggleProcessor<J> {
    /**
     * Annotation processing
     *
     * @param joinPoint - join point
     */
    public abstract void processFeatureToggle(J joinPoint);
}
