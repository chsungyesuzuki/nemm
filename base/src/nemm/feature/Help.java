package nemm.feature;

public class Help {
    public static void execute (String[] splittedCmd) {
        System.out.println("\"help\" to see help.");
        System.out.println("\"fork from to [description]\" to fork playlist.");
        System.out.println("\"login phone|email phonenumber|emailaddress password\" to login.");
        System.out.println("Successfully helped!");
    }
}
