package nemm.feature;

public class FeatureExecutor {
    public static void execute(String[] splittedCmd) {
        Feature feature;
        switch(splittedCmd[0]) {
            case "fork":
                feature = new Fork();
                break;
            case "login":
                feature = new Login();
                break;
            case "help":
                feature = new Help();
                break;
            default:
                throw new IllegalArgumentException("Type help to see help.");
        }
        feature.execute(splittedCmd);
    }
}
