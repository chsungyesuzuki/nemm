package nemm.jsonparse;

public class JSONObjectArray implements JSONGlyph {
    public String id;
    public JSONObject[] value;
    public JSONObjectArray(String id, JSONObject[] value) {
        this.id = id;
        this.value = value;
    }
}
