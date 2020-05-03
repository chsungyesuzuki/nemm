package nemm.jsonparse;

public class JSONStringArray implements JSONGlyph {
    public String id;
    public String[] value;
    public JSONStringArray(String id, String[] value) {
        this.id = id;
        this.value = value;
    }
}
