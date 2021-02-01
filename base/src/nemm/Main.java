package nemm;

import nemm.feature.FeatureExecutor;
import nemm.http.HttpClient;

import java.time.Duration;
import java.util.Scanner;

/**
 * Nothing to say.
 * @version 0.0.0
 * @since 0.0.0
 * @author chsungyesuzuki
 */
public class Main{
    /**
     * The http client the program uses.
     * @since 0.0.0
     */
    public static HttpClient client;

    /**
     * nothing to say.
     * @param args nothing to say.
     * @since 0.0.0
     */
    public static void main(String[]args){
        client=HttpClient.INSTANCE;
        Scanner scanner=new Scanner(System.in);
        while(true) {
            String cmd = scanner.nextLine();
            String[] splitCmd = cmd.split(" ");
            FeatureExecutor.execute(splitCmd);
        }
    }
}
