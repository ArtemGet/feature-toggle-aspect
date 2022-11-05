package artemget.featuretoggle.aspect;

import artemget.featuretoggle.annotation.ToggleFeature;
import artemget.featuretoggle.exception.FeatureDisabledException;
import artemget.featuretoggle.exception.errorCode.ErrorCodeTemplate;
import artemget.featuretoggle.feature.Feature;
import artemget.featuretoggle.feature.FeatureContainer;
import org.aspectj.lang.JoinPoint;

public class SingleToggleChain extends SpringToggleChain<JoinPoint, ToggleFeature> {

    public SingleToggleChain(Class<ToggleFeature> targetAnnotation,
                             AbstractToggleChain<JoinPoint, ?> nextProcessor,
                             FeatureContainer featureContainer) {
        super(nextProcessor, targetAnnotation, featureContainer);
    }

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
