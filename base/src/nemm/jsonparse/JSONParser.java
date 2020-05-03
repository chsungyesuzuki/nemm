package nemm.jsonparse;

import nemm.Utils;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public final class JSONParser {
    private JSONParser(){}
    public static JSONObject fromFile(File file) throws IOException {
        var input = new FileReader(file);
        List<JSONObject> version = new LinkedList<>();
        JSONObject res = new JSONObject(null, null);
        version.add(res);
        boolean left = true;
        int c = input.read();
        while (c != -1) {
            boolean inString = false;
            List<Character> buf = new LinkedList<>();
            while (true) {
                if (c == '"') {
                    inString = !inString;
                }
                else if (inString) {
                    buf.add((char)c);
                }
                else if(c == ':') {
                    break;
                }
                c = input.read();
            }
            String id = Utils.characterToString((Character[]) buf.toArray());
            while(true) {
                
            }
        }
        return null;
    }
}
