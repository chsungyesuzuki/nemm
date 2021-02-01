//Copyright 2021 chsungyesuzuki
//This file is part of nemm.
//
//        nemm is free software: you can redistribute it and/or modify
//      it under the terms of the GNU General Public License as published by
//    the Free Software Foundation, either version 3 of the License, or
//  (at your option) any later version.
//
//      nemm is distributed in the hope that it will be useful,
//    but WITHOUT ANY WARRANTY; without even the implied warranty of
//  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//GNU General Public License for more details.
//
//      You should have received a copy of the GNU General Public License
//    along with Foobar.  If not, see <https://www.gnu.org/licenses/>.
package nemm.core;

import com.google.gson.*;
import nemm.http.HttpClient;
import nemm.Main;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Playlist.
 * @since 1.0.2
 * @author chsungyesuzuki
 */
public class Playlist{
    /**
     * id
     * @since 1.0.5
     */
    public final String id;

    private JsonObject jsonObject;
    private static String defaultDescription="generated+by+nemm";
    private static final HttpClient client=Main.client;

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
     * create a new playlist (both online and a Playlist object) using given name and discription
     * @since 1.0.5
     * @author chsungyesuzuki
     * @param name new playlist's name
     * @param description new playlist's description
     * @return the Playlist object
     * @throws IOException when the reader could not be closed normally
     */
    public static Playlist create(String name,String description) throws IOException {
        BufferedReader reader=client.runCommand("playlist/create?name="+name);
        assert reader!=null;
        JsonElement e=JsonParser.parseReader(reader);
        JsonObject o=e.getAsJsonObject();
        JsonPrimitive p=o.getAsJsonPrimitive("id");
        String s=p.getAsString();
        client.runCommand("playlist/desc/update?id="+s+"&desc="+description);
        reader.close();
        return new Playlist(s);
    }

    /**
     * nts, see above
     * @since 1.0.5
     * @author chsungyesuzuki
     * @param name nts
     * @return nts
     * @throws IOException nts
     */
    public static Playlist create(String name) throws IOException {
        return create(name,defaultDescription);
    }

    /**
     * set default desc
     * @since 1.0.5
     * @author chsungyesuzuki
     * @param newDescription new desc
     */
    public static void setDefaultDescription(String newDescription){
        defaultDescription=newDescription;
    }

    /**
     * nts
     * @since 1.0.5
     * @author chsungyesuzuki
     * @param trackIds nts
     */
    public void addTracks(String[]trackIds){
        StringBuilder com=new StringBuilder("playlist/tracks?op=add&pid="+id+"&tracks=");
        for(String trackId:trackIds){
            com.append(trackId).append(",");
        }
        com=new StringBuilder(com.substring(0,com.length()-1));
        client.runCommand(com.toString());
    }

    /**
     * get playlist jsonObject from api
     * @return jsonObject
     * @author chsungyesuzuki
     * @since 1.0.2
     */
    public final JsonObject get() throws IOException {
        String str="playlist/detail?id="+id;
        BufferedReader reader=client.runCommand(str);
        assert reader!=null;
        JsonElement element=JsonParser.parseReader(reader);
        jsonObject=element.getAsJsonObject();
        reader.close();
        return jsonObject;
    }

    /**
     * getSongIds
     * @return songIds
     * @author chsungyesuzuki
     * @since 1.0.2
     */
    public final String[]getTrackIds() throws IOException {
        if(jsonObject==null){
            get();
        }
        JsonObject playlist=jsonObject.getAsJsonObject("playlist");
        JsonArray trackIds=playlist.getAsJsonArray("trackIds");
        String[]res=new String[trackIds.size()];
        for(int i=0;i!=trackIds.size();i++){
            JsonElement ele=trackIds.get(i);
            JsonObject obj1=ele.getAsJsonObject();
            JsonPrimitive id=obj1.getAsJsonPrimitive("id");
            String ids=id.getAsString();
            res[i]=ids;
        }
        return res;
    }
}
