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
package nemm.http;

import nemm.http.exception.No200Exception;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.List;
import java.util.Map;

/**
 * an http client.
 * @version 0.0.0
 * @since 0.0.0
 * @author chsungyesuzuki
 */
public class HttpClient{
    /**
     * the name of cookie.
     * @since 0.0.0
     */
    public long cookie;
    public static final HttpClient INSTANCE;
    static{
        java.net.http.HttpClient.Builder cBuilder = java.net.http.HttpClient.newBuilder();
        cBuilder.connectTimeout(Duration.ofSeconds(15));
        cBuilder.version(java.net.http.HttpClient.Version.HTTP_1_1);
        java.net.http.HttpClient client0 = cBuilder.build();
        INSTANCE=new HttpClient(client0);
    }
    private final java.net.http.HttpClient client;

    private HttpClient(java.net.http.HttpClient client){
        this.client=client;
    }

    /**
     * run command.
     * @since 0.0.0
     * @param cmd cmd.
     * @return a buffered reader of the response body.
     */
    public final BufferedReader runCommand(String cmd){
        try{
            if(cookie==0){
                cookie=System.currentTimeMillis();
            }
            File ifile=new File("/home/chsungyesuzuki/temp/"+cookie);
            cmd="http://localhost:3000/"+cmd;
            URI playlist=new URI(cmd);
            HttpRequest.Builder rBuilder=HttpRequest.newBuilder(playlist);
            rBuilder.GET();
            rBuilder.timeout(Duration.ofSeconds(15));
            rBuilder.version(java.net.http.HttpClient.Version.HTTP_1_1);
            if(ifile.exists()){
                BufferedReader rer=new BufferedReader(new FileReader(ifile));
                while(true){
                    String line=rer.readLine();
                    if(line==null)break;
                    rBuilder.header("cookie",line);
                }
            }
            HttpRequest request=rBuilder.build();
            HttpResponse.BodyHandler<InputStream>bodyType=HttpResponse.BodyHandlers.ofInputStream();
            HttpResponse<InputStream>response=client.send(request,bodyType);
            int statusCode=response.statusCode();
            if(statusCode==200){
                HttpHeaders headers=response.headers();
                Map<String,List<String>>headersMap=headers.map();
                if(headersMap.containsKey("set-cookie")){
                    List<String>list=headersMap.get("set-cookie");
                    if(!ifile.exists()){
                        ifile.createNewFile();
                    }
                    Writer qwq=new FileWriter(ifile);
                    for(String i:list){
                        qwq.write(i+"\n");
                    }
                    qwq.close();
                }
                return new BufferedReader(new InputStreamReader(response.body()));
            }
            else{
                throw new No200Exception(response);
            }
        }
        catch(URISyntaxException|InterruptedException|IOException e){
            e.printStackTrace();
            return null;
        }
    }
}
