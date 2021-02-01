package nemm.feature;

import nemm.Main;
import nemm.http.HttpClient;

import java.io.Console; 

/**
 * login feature.
 * @version 0.0.0
 * @since 0.0.0
 * @author chsungyesuzuki
 */
public final class Login implements Feature{
    private static final HttpClient client=Main.client;
    /**
     * implementation.
     * @since 0.0.0
     * @param splitCmd split cmd.
     */
    public void execute(String[]splitCmd){
        try{
            if(splitCmd[1].equals("phone")){
                phone(splitCmd[2],splitCmd[3]);
            }
            else if(splitCmd[2].equals("email")){
                email(splitCmd[2],splitCmd[3]);
            }
            else throw new IllegalArgumentException("Wrong syntax, type help login to help");
        }catch(ArrayIndexOutOfBoundsException e){
            throw new IllegalArgumentException("Wrong syntax, type help login to help");
        }
        System.out.println("Successfully logged in!");
    }

    private static void email(String email,String password){
        String ss="login?email="+email+"&password="+password;
        client.runCommand(ss);
    }

    private static void phone(String phone,String password){
        String ss="login/cellphone?phone="+phone+"&password="+password;
        client.runCommand(ss);
    }
}
