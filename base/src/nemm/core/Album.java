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

import java.io.BufferedReader;
import java.io.IOException;

public class Album {
    private String id;
    private HttpClient client;
    private JsonObject jsonObject;
    public Album(String id){
        this.id=id;
    }
    /**
     * get album jsonObject from api
     * @return jsonObject
     * @author chsungyesuzuki
     * @since 1.1.0
     */
    public final JsonObject get() throws IOException {
        String str="album?id="+id;
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
     * @since 1.1.0
     */
    public final String[]getTrackIds() throws IOException {
        if(jsonObject==null){
            get();
        }
        JsonArray songs=jsonObject.getAsJsonArray("songs");
        String[]res=new String[songs.size()];
        for(int i=0;i!=songs.size();i++){
            JsonElement ele=songs.get(i);
            JsonObject obj1=ele.getAsJsonObject();
            JsonPrimitive id=obj1.getAsJsonPrimitive("id");
            String ids=id.getAsString();
            res[i]=ids;
        }
        return res;
    }
}
