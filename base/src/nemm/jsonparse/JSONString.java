package nemm.jsonparse;

public class JSONString implements JSONGlyph {
    public String id;
    public String value;
    public JSONString(String id, String value) {
        this.id = id;
        this.value = value;
    }
}
