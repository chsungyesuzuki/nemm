package nemm;

import nemm.feature.FeatureExecutor;

import java.time.Duration;
import java.util.Scanner;

/**
 * Nothing to say.
 * @version 0.0.0
 * @since 0.0.0
 * @author chsungyesuzuki
 */
public class Main {
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
    public static void main(String[] args) {
        var cBuilder = java.net.http.HttpClient.newBuilder();
        cBuilder.connectTimeout(Duration.ofSeconds(15));
        cBuilder.version(java.net.http.HttpClient.Version.HTTP_1_1);
        var client0 = cBuilder.build();
        client = new HttpClient(client0);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String cmd = scanner.nextLine();
            String[] splittedCmd = cmd.split(" ");
            FeatureExecutor.execute(splittedCmd);
        }
    }
}
