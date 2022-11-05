package artemget.featuretoggle.exception;

public class FeatureDisabledException extends Exception {
    public FeatureDisabledException() {
    }

    public FeatureDisabledException(String message) {
        super(message);
    }

    public FeatureDisabledException(String message, Throwable cause) {
        super(message, cause);
    }

    public FeatureDisabledException(Throwable cause) {
        super(cause);
    }
}
