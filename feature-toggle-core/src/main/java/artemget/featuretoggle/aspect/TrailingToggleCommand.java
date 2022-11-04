package artemget.featuretoggle.aspect;

import java.lang.annotation.Annotation;

public class TrailingToggleCommand<J,A extends Annotation> extends AbstractToggleCommand<J,A> {
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
