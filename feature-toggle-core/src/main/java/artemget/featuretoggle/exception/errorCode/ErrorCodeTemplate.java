package artemget.featuretoggle.exception.errorCode;

/**
 * Error code pattern
 */
public class ErrorCodeTemplate {
    private ErrorCodeTemplate() {

    }

    public static final String FEATURE_NOT_FOUND = "No feature found for name %s";
    public static final String FEATURE_DISABLED = "Feature %s disabled";
}
