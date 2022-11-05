package artemget.featuretoggle.aspect;

import java.lang.annotation.Annotation;

/**
 * Abstract feature toggle processor, follows ToggleProcessor contract
 *
 * @param <J> -generic joinPoint
 */
abstract class AbstractToggleAspect<J> implements ToggleProcessor<J> {
    protected final AbstractToggleChain<J, ? extends Annotation> toggleCommand;

    protected <A extends Annotation> AbstractToggleAspect(AbstractToggleChain<J, A> toggleCommand) {
        this.toggleCommand = toggleCommand;
    }
}
