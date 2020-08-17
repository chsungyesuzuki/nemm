package nemm.feature;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import nemm.Main;
import nemm.core.Playlist;
import nemm.httpexception.No200Exception;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * fork feature.
 * @version 0.0.0
 * @since 0.0.0
 * @author chsungyesuzuki
 */
public final class Fork implements Feature {
    /**
     * implementation.
     * @since 0.0.0
     * @param splittedCmd splitted cmd.
     */
    public void execute(String[] splittedCmd) {
        if(splittedCmd.length != 3 && splittedCmd.length != 4) {
            throw new IllegalArgumentException("The correct grammar of \"fork\" is: \"fork from to [description]\"");
        }
        String from = splittedCmd[1];
        String to = splittedCmd[2];
        nemm.HttpClient client = Main.client;
        try {
            BufferedReader reader = client.runCommand("playlist/create?name=" + to);
            assert reader != null;
            JsonElement e = JsonParser.parseReader(reader);
            JsonObject o = e.getAsJsonObject();
            JsonPrimitive p = o.getAsJsonPrimitive("id");
            String s = p.getAsString();
            if(splittedCmd.length == 3) {
                client.runCommand("playlist/desc/update?id=" + s + "&desc=generated+by+nemm");
            } else {
                client.runCommand("playlist/desc/update?id=" + s + "&desc=" + splittedCmd[3]);
            }
            Playlist pl=new Playlist(from);
            String[] trackIds = pl.getTrackIds();
            StringBuilder com = new StringBuilder("playlist/tracks?op=add&pid=" + s + "&tracks=");
            for (String trackId : trackIds) {
                com.append(trackId).append(",");
            }
            com = new StringBuilder(com.substring(0, com.length() - 1));
            client.runCommand(com.toString());
            System.out.println("Successfully forked!");
            reader.close();
        }
        catch (No200Exception e) {
            System.err.println(e.response);
            System.err.println(e.response.headers());
            System.err.println(e.response.body());
            throw e;
        } catch (IllegalStateException | NullPointerException | IOException e){
            e.printStackTrace();
        }
    }
}
