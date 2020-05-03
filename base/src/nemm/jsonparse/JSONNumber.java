package nemm.jsonparse;

public class JSONNumber implements JSONGlyph {
    public String id;
    public float value;
    public JSONNumber(String id, float value) {
        this.id = id;
        this.value = value;
    }
}
