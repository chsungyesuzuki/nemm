package nemm.jsonparse;

public interface JSONGlyph {
    public String id = "";
    public default String id() {
        return id;
    };
}
