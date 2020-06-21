package nemm.feature;

/**
 * Help feature.
 * @version 0.0.0
 * @since 0.0.0
 * @author chsungyesuzuki
 */
public class Help {
    /**
     * implementation.
     * @since 0.0.0
     * @param splittedCmd useless.
     */
    public static void execute (String[] splittedCmd) {
        System.out.println("\"help\" to see help.");
        System.out.println("\"fork from to [description]\" to fork playlist.");
        System.out.println("\"login phone|email phonenumber|emailaddress\" to login.");
        System.out.println("Successfully helped!");
    }
}
