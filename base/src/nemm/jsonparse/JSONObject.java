package nemm.jsonparse;

public class JSONObject implements JSONGlyph {
    public String id;
    public JSONGlyph[] value;
    public JSONObject(String id, JSONGlyph[] value) {
        this.id = id;
        this.value = value;
    }
}
