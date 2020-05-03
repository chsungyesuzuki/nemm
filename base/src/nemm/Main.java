package nemm;

import nemm.feature.Fork;
import nemm.feature.Login;

import java.time.Duration;
import java.util.Scanner;

public class Main {
    public static HttpClient client;
    public static void main(String[] args) {
        var cBuilder = java.net.http.HttpClient.newBuilder();
        cBuilder.connectTimeout(Duration.ofSeconds(15));
        cBuilder.version(java.net.http.HttpClient.Version.HTTP_1_1);
        var client0 = cBuilder.build();
        client = new HttpClient(client0);
        Scanner scanner = new Scanner(System.in);
        String cmd = scanner.nextLine();
        String[] splittedCmd = cmd.split(" ");
        switch(splittedCmd[0]) {
            case "fork":
                Fork.execute(splittedCmd);
                break;
            case "login":
                Login.execute(splittedCmd);
                break;
            case "help":

            default:
                throw new IllegalArgumentException("Type help to see help.");
        }
    }
}
