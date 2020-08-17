package nemm.core;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import nemm.HttpClient;
import nemm.Main;

import java.io.BufferedReader;

/**
 * Playlist.
 * @since 1.0.2
 * @author chsungyesuzuki
 */
public class Playlist {
    private final String id;
    private JsonObject jsonObject;

    /**
     * You must provide id to get a Playlist.
     * @param id id
     * @author chsungyesuzuki
     * @since 1.0.2
     */
    public Playlist(String id){
        this.id=id;
    }

    /**
     * get playlist jsonObject from api
     * @return jsonObject
     * @author chsungyesuzuki
     * @since 1.0.2
     */
    public JsonObject get(){
        HttpClient client= Main.client;
        String str = "playlist/detail?id=" + id;
        BufferedReader r0 = client.runCommand(str);
        assert r0 != null;
        var element = JsonParser.parseReader(r0);
        jsonObject=element.getAsJsonObject();
        return jsonObject;
    }

    /**
     * getSongIds
     * @return songIds
     * @author chsungyesuzuki
     * @since 1.0.2
     */
    public String[] getTrackIds(){
        if(jsonObject==null){
            get();
        }
        var playlist = jsonObject.getAsJsonObject("playlist");
        var trackIds = playlist.getAsJsonArray("trackIds");
        String[] res=new String[trackIds.size()];
        for (int i=0;i!=trackIds.size();i++) {
            var ele=trackIds.get(i);
            var obj1 = ele.getAsJsonObject();
            var id = obj1.getAsJsonPrimitive("id");
            var ids = id.getAsString();
            res[i]=ids;
        }
        return res;
    }
}
