package artemget.featuretoggle.aspect;

import artemget.featuretoggle.aspect.command.AbstractToggleCommand;

/**
 * Abstract feature toggle processor
 *
 * @param <J> - joinPoint, rely on realization
 */
public abstract class AbstractToggleAspect<J> implements ToggleProcessor<J> {
    protected final AbstractToggleCommand<J, ?> toggleCommand;

    protected AbstractToggleAspect(AbstractToggleCommand<J, ?> toggleCommand) {
        this.toggleCommand = toggleCommand;
    }
}
