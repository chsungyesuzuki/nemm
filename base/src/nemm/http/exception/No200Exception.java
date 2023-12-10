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
package nemm.http.exception;

import java.net.http.HttpResponse;

/**
 * an exception about that the response code is not 200.
 * @version 0.0.0
 * @since 0.0.0
 * @author chsungyesuzuki
 */
public class No200Exception extends RuntimeException {
    /**
     * the response whose code is not 200.
     * @since 0.0.0
     */
    public HttpResponse<?> response;
    /**
     * constructor.
     * @since 0.0.0
     * @param response response.
     */
    public No200Exception (HttpResponse<?> response) {
        this.response = response;
    }
}
