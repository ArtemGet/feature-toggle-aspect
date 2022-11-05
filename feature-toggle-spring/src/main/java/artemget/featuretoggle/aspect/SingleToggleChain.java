package artemget.featuretoggle.aspect;

import artemget.featuretoggle.annotation.ToggleFeature;
import artemget.featuretoggle.exception.FeatureDisabledException;
import artemget.featuretoggle.exception.errorCode.ErrorCodeTemplate;
import artemget.featuretoggle.feature.Feature;
import artemget.featuretoggle.feature.FeatureContainer;
import org.aspectj.lang.JoinPoint;

/**
 * Feature toggle chain, process ToggleFeature annotation
 */
public class SingleToggleChain extends SpringToggleChain<JoinPoint, ToggleFeature> {

    public SingleToggleChain(Class<ToggleFeature> targetAnnotation,
                             AbstractToggleChain<JoinPoint, ?> nextProcessor,
                             FeatureContainer featureContainer) {
        super(nextProcessor, targetAnnotation, featureContainer);
    }

    /**
     * Should process target annotation if exists in join point.
     * FeatureContainer provides feature for name if exists.
     * In case of nothing found should pass processing to nextProcessor
     *
     * @param joinPoint - join point
     */
    @Override
    public void processFeatureToggle(JoinPoint joinPoint) throws FeatureDisabledException {
        ToggleFeature annotation = ejectAnnotation(joinPoint);
        super.nextOrThrowOrPass(annotation == null,
                nextProcessor,
                joinPoint);

        String featureName = annotation.featureName();
        Feature containedFeature = featureContainer.getFeature(featureName);

        if (containedFeature.isDisabled()) {
            String errorMessage = String.format(ErrorCodeTemplate.FEATURE_DISABLED, featureName);
            throw new FeatureDisabledException(errorMessage);
        }
    }
}
