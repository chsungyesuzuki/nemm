package nemm.feature;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import nemm.Main;
import nemm.core.Playlist;
import nemm.http.HttpClient;
import nemm.http.exception.No200Exception;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * fork feature.
 * @version 0.0.0
 * @since 0.0.0
 * @author chsungyesuzuki
 */
public final class Fork implements Feature{
    /**
     * implementation.
     * @since 0.0.0
     * @param splittedCmd splitted cmd.
     */
    public void execute(String[]splittedCmd){
        if(splittedCmd.length!=3&&splittedCmd.length!=4){
            throw new IllegalArgumentException("Wrong syntax, type help fork to help");
        }
        String from=splittedCmd[1];
        String to=splittedCmd[2];
        HttpClient client=Main.client;
        try{
            Playlist targetPlaylist;
            if(splittedCmd.length==4){
                String description=splittedCmd[3];
                targetPlaylist=Playlist.create(to,description);
            }else{
                targetPlaylist=Playlist.create(to);
            }
            Playlist pl=new Playlist(from);
            String[]trackIds=pl.getTrackIds();
            targetPlaylist.addTracks(trackIds);
            System.out.println("Successfully forked!");
        }
        catch(No200Exception e){
            System.err.println(e.response);
            System.err.println(e.response.headers());
            System.err.println(e.response.body());
            throw e;
        }catch(IllegalStateException|NullPointerException|IOException e){
            e.printStackTrace();
        }
    }
}
