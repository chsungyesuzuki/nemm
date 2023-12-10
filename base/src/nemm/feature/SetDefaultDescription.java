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
package nemm.feature;
import nemm.core.Playlist;

public class SetDefaultDescription implements Feature{
    public void execute(String[]splitCmd){
        Playlist.setDefaultDescription(splitCmd[1]);
    }
}
