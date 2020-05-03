package nemm.feature;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import nemm.Main;
import nemm.httpexception.No200Exception;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.time.Duration;

public final class Fork {
    public static void execute(String[] splittedCmd) {
        if(splittedCmd.length != 3 && splittedCmd.length != 4) {
            throw new IllegalArgumentException("The correct grammar of \"fork\" is: \"fork from to [description]\"");
        }
        String from = splittedCmd[1];
        String to = splittedCmd[2];
        nemm.HttpClient client = Main.client;
        try {
            String str = "http://localhost:3000/playlist/detail?id=" + from;
            var playlist0 = new URI(str);
            BufferedReader r0 = client.runCommand(str);
            var rBuilder = HttpRequest.newBuilder(playlist0);
            rBuilder.GET();
            rBuilder.timeout(Duration.ofSeconds(15));
            rBuilder.version(HttpClient.Version.HTTP_1_1);
            assert r0 != null;
            var element = JsonParser.parseReader(r0);
            var obj = element.getAsJsonObject();
            var playlist = obj.getAsJsonObject("playlist");
            var trackIds = playlist.getAsJsonArray("trackIds");
            BufferedReader r1 = client.runCommand("playlist/create?name=" + to);
            assert r1 != null;
            JsonElement e = JsonParser.parseReader(r1);
            JsonObject o = e.getAsJsonObject();
            JsonPrimitive p = o.getAsJsonPrimitive("id");
            String s = p.getAsString();
            if(splittedCmd.length == 3) {
                client.runCommand("playlist/desc/update?id=" + s + "&desc=generated+by+nemm");
            } else {
                client.runCommand("playlist/desc/update?id=" + s + "&desc=" + splittedCmd[3]);
            }
            StringBuilder com = new StringBuilder("playlist/tracks?op=add&pid=" + s + "&tracks=");
            for (JsonElement i : trackIds) {
                var obj1 = i.getAsJsonObject();
                var id = obj1.getAsJsonPrimitive("id");
                var ids = id.getAsString();
                com.append(ids).append(",");
            }
            com = new StringBuilder(com.substring(0, com.length() - 1));
            client.runCommand(com.toString());
            System.out.println("Successfully forked!");
            r0.close();
            r1.close();
        }
        catch (No200Exception e) {
            System.err.println(e.response);
            System.err.println(e.response.headers());
            System.err.println(e.response.body());
            throw e;
        } catch (IllegalStateException | NullPointerException | IOException | URISyntaxException e){
            e.printStackTrace();
        }
    }
}
