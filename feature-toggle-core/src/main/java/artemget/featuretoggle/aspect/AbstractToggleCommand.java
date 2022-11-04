package artemget.featuretoggle.aspect;

import artemget.featuretoggle.feature.FeatureContainer;

import java.lang.annotation.Annotation;

abstract class AbstractToggleCommand<J, A extends Annotation> implements ToggleProcessor<J> {
    protected final AbstractToggleCommand<J, ?> nextProcessor;
    protected final Class<A> TARGET_ANNOTATION;
    protected final FeatureContainer featureManager;

    AbstractToggleCommand(AbstractToggleCommand<J, ?> nextProcessor,
                          Class<A> targetAnnotation,
                          FeatureContainer featureManager) {
        this.nextProcessor = nextProcessor;
        this.TARGET_ANNOTATION = targetAnnotation;
        this.featureManager = featureManager;
    }

    protected abstract A ejectAnnotation(J joinPoint);
}
