package artemget.featuretoggle.aspect.command;

import artemget.featuretoggle.aspect.ToggleProcessor;
import artemget.featuretoggle.feature.FeatureContainer;

public abstract class AbstractToggleCommand<J, A> implements ToggleProcessor<J> {
    private final AbstractToggleCommand<J, ?> nextProcessor;
    private final Class<A> TARGET_ANNOTATION;
    private final FeatureContainer featureManager;

    public AbstractToggleCommand(AbstractToggleCommand<J, ?> nextProcessor,
                                 Class<A> target_annotation,
                                 FeatureContainer featureManager) {
        this.nextProcessor = nextProcessor;
        this.TARGET_ANNOTATION = target_annotation;
        this.featureManager = featureManager;
    }

    protected abstract A ejectAnnotation(J joinPoint);
}
