package artemget.featuretoggle.exception;

public class FeatureNotFoundEx extends RuntimeException {
    public FeatureNotFoundEx() {
    }

    public FeatureNotFoundEx(String message) {
        super(message);
    }

    public FeatureNotFoundEx(String message, Throwable cause) {
        super(message, cause);
    }

    public FeatureNotFoundEx(Throwable cause) {
        super(cause);
    }

    public FeatureNotFoundEx(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
