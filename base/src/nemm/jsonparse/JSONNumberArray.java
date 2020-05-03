package nemm.jsonparse;

public class JSONNumberArray implements JSONGlyph {
    public String id;
    public float[] value;
    public JSONNumberArray(String id, float[] value) {
        this.id = id;
        this.value = value;
    }
}
