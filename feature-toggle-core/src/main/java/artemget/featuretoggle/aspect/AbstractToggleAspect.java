package artemget.featuretoggle.aspect;

import java.lang.annotation.Annotation;

/**
 * Abstract feature toggle processor
 *
 * @param <J> - joinPoint, rely on realization
 */
abstract class AbstractToggleAspect<J> implements ToggleProcessor<J> {
    protected final AbstractToggleChain<J, ? extends Annotation> toggleCommand;

    protected <A extends Annotation> AbstractToggleAspect(AbstractToggleChain<J, A> toggleCommand) {
        this.toggleCommand = toggleCommand;
    }
}
