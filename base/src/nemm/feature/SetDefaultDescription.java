package nemm.feature;
import nemm.core.Playlist;

public class SetDefaultDescription implements Feature{
    public void execute(String[]splitCmd){
        Playlist.setDefaultDescription(splitCmd[1]);
    }
}
