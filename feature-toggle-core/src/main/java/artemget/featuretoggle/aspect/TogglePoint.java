package artemget.featuretoggle.aspect;

public interface TogglePoint {
    /**
     * Points where aspect should process on Class layer
     */
    void classLayerPointcut();

    /**
     * Points where aspect should process on method layer
     */
    void methodLayerPointcut();
}
