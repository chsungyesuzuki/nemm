package nemm.feature;

/**
 * Exit feature.
 * @author chsungyesuzuki
 * @since 1.0.0
 */
public final class Exit implements Feature{
    /**
     * nts
     * @param splittedCmd nts, unused
     * @since 1.0.0
     */
    public void execute(String[]splittedCmd){
        System.exit(0);
    }
}
