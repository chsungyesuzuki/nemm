package nemm.feature;

/**
 * Help feature.
 * @version 0.0.0
 * @since 0.0.0
 * @author chsungyesuzuki
 */
public final class Help implements Feature{
    private void defaultHelp(){
        System.out.println("\"help\" to see help.");
        System.out.println("\"fork\" to fork playlist.");
        System.out.println("\"login\" to login.");
        System.out.println("\"exit\" to exit the program.");
        System.out.println("\"setDefaultDescription\" to set default description of the playlist created by nemm.");
    }
    /**
     * implementation.
     * @since 0.0.0
     * @param splitCmd useless.
     */
    public void execute(String[]splitCmd){
        if(splitCmd.length==1){
            defaultHelp();
        }else{
            switch(splitCmd[1]){
                case"help"->{
                    System.out.println("SYNOPSIS:");
                    System.out.println("\thelp [command]");
                    System.out.println("OPTIONS:");
                    System.out.println("\tcommand - command to help");
                }
                case"fork"->{
                    System.out.println("SYNOPSIS:");
                    System.out.println("\tfork origin_id target_name [description]");
                    System.out.println("OPTIONS:");
                    System.out.println("\torigin_id - origin playlist id");
                    System.out.println("\ttarget_name - target playlist name");
                    System.out.println("\tdescription - target playlist's description");
                    System.out.println("\t\tplease replace ' ' with '+' in description.");
                }
                case"login"->{
                    System.out.println("SYNOPSIS:");
                    System.out.println("\tlogin phone phone_number password");
                    System.out.println("\tlogin email email_address password");
                    System.out.println("OPTIONS:");
                    System.out.println("\tphone_number - your account's phone number");
                    System.out.println("\temail_address - your account's email address");
                    System.out.println("\tpassword - your account's password");
                }
                case"exit"->{
                    System.out.println("SYNOPSIS:");
                    System.out.println("\texit");
                }
                case"setDefaultDescription"->{
                    System.out.println("SYNOPSIS:");
                    System.out.println("\tsetDefaultDescription desc");
                    System.out.println("OPTIONS:");
                    System.out.println("\tdesc - the new default description you want to set");
                }
                default->defaultHelp();
            }
        }
        System.out.println("Successfully helped!");
    }
}
