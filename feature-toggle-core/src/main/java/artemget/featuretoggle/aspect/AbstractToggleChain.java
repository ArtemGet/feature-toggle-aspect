package artemget.featuretoggle.aspect;

import artemget.featuretoggle.feature.FeatureContainer;

import java.lang.annotation.Annotation;

/**
 * Base feature toggle chain class, follows ToggleProcessor contract
 *
 * @param <J> - generic join point
 * @param <A> - generic target annotation, ex: ToggleFeature/ToggleFeatures
 */
abstract class AbstractToggleChain<J, A extends Annotation> implements ToggleProcessor<J> {
    protected final AbstractToggleChain<J, ?> nextProcessor;
    protected final Class<A> TARGET_ANNOTATION;
    protected final FeatureContainer featureContainer;

    AbstractToggleChain(AbstractToggleChain<J, ?> nextProcessor,
                        Class<A> targetAnnotation,
                        FeatureContainer featureManager) {
        this.nextProcessor = nextProcessor;
        this.TARGET_ANNOTATION = targetAnnotation;
        this.featureContainer = featureManager;
    }

    /**
     * Should process target annotation if exists in join point.
     * FeatureContainer provides feature for name if exists.
     * In case of nothing found should pass processing to nextProcessor
     *
     * @param joinPoint - generic join point
     * @return target annotation
     */
    protected abstract A ejectAnnotation(J joinPoint);
}
