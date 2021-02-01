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

/**
 * Exit feature.
 * @author chsungyesuzuki
 * @since 1.0.0
 */
public final class Exit implements Feature{
    /**
     * nts
     * @param splitCmd nts, unused
     * @since 1.0.0
     */
    public void execute(String[] splitCmd){
        System.exit(0);
    }
}
