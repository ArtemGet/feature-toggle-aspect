package artemget.featuretoggle.aspect.command;

public class TrailingToggleCommand<J,A> extends AbstractToggleCommand<J,A> {
    public TrailingToggleCommand() {
        super(null, null, null);
    }

    @Override
    protected A ejectAnnotation(J joinPoint) {
        return null;
    }

    @Override
    public void processFeatureToggle(J joinPoint) {

    }
}
