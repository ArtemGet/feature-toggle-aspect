package artemget.featuretoggle.aspect;

import artemget.featuretoggle.annotation.ToggleFeature;
import artemget.featuretoggle.annotation.ToggleFeatures;
import artemget.featuretoggle.exception.FeatureDisabledException;
import artemget.featuretoggle.exception.errorCode.ErrorCodeTemplate;
import artemget.featuretoggle.feature.Feature;
import artemget.featuretoggle.feature.FeatureContainer;
import org.aspectj.lang.JoinPoint;

import java.lang.annotation.Annotation;

/**
 * Feature toggle chain, process ToggleFeatures annotation
 */
public class MultipleToggleChain extends SpringToggleChain<JoinPoint, ToggleFeatures> {

    public MultipleToggleChain(Class<ToggleFeatures> targetAnnotation,
                               AbstractToggleChain<JoinPoint, ? extends Annotation> nextProcessor,
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
        ToggleFeatures annotation = ejectAnnotation(joinPoint);
        super.nextOrThrowOrPass(annotation == null,
                nextProcessor,
                joinPoint);

        ToggleFeature[] features = annotation.features();
        super.nextOrThrowOrPass(
                features == null || features.length == 0,
                nextProcessor,
                joinPoint);

        for (ToggleFeature featureAnnotation : features) {
            super.nextOrThrowOrPass(featureAnnotation == null,
                    nextProcessor,
                    joinPoint);

            String featureName = featureAnnotation.featureName();
            Feature containedFeature = featureContainer.getFeature(featureName);

            if (containedFeature.isDisabled()) {
                String errorMessage = String.format(ErrorCodeTemplate.FEATURE_DISABLED, featureName);
                throw new FeatureDisabledException(errorMessage);
            }
        }
    }
}
