package nemm.feature;

import nemm.httpexception.No200Exception;

/**
 * Feature Executor
 * @author chsungyesuzuki
 * @since 0.0.2
 */
public class FeatureExecutor {
    /**
     * nts
     * @since 0.0.2
     * @param splittedCmd nts
     */
    public static void execute(String[] splittedCmd) {
        Feature feature = switch (splittedCmd[0]) {
            case "help" -> new Help();
            case "fork" -> new Fork();
            case "login" -> new Login();
            default -> throw new IllegalArgumentException();
        };
        try {
            feature.execute(splittedCmd);
        } catch (No200Exception e) {
            if(e.response.statusCode()==301) {
                System.err.println("login first please!");
            }
        }
    }
}
