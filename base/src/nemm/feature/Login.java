package nemm.feature;

import nemm.Main;

import java.io.Console; 

/**
 * login feature.
 * @version 0.0.0
 * @since 0.0.0
 * @author chsungyesuzuki
 */
public final class Login implements Feature{
    /**
     * implementation.
     * @since 0.0.0
     * @param splittedCmd splitted cmd.
     */
    public void execute(String[] splittedCmd) {
        try {
            if (splittedCmd[1] .equals("phone") ) phone(splittedCmd[2], splittedCmd[3]);
            else if (splittedCmd[2] .equals("email") ) email(splittedCmd[2], splittedCmd[3]);
            else throw new IllegalArgumentException("login failed because Illegal Argument");
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException("login failed because Illegal Argument");
        }
        System.out.println("Successfully loggedin!");
    }

    private static void email(String email, String password) {
        String ss = "login?email="+email+"&password="+password;
        Main.client.runCommand(ss);
    }

    private static void phone(String phone, String password) {
        String ss = "login/cellphone?phone=" + phone +"&password="+password;
        Main.client.runCommand(ss);
    }
}
