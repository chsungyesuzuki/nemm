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

import nemm.http.exception.No200Exception;

/**
 * Feature Executor
 * @author chsungyesuzuki
 * @since 0.0.2
 */
public final class FeatureExecutor{
    /**
     * nts
     * @since 0.0.2
     * @param splitCmd nts
     */
    public static void execute(String[]splitCmd){
        Feature feature=switch(splitCmd[0]){
            case"help"->new Help();
            case"fork"->new Fork();
            case"login"->new Login();
            case"exit"->new Exit();
            case"setDefaultDescription"->new SetDefaultDescription();
            default->throw new IllegalArgumentException("unknown command. type help to get help.");
        };
        try{
            feature.execute(splitCmd);
        }catch(No200Exception e){
            if(e.response.statusCode()==301){
                System.err.println("login first please!");
            }else{
                throw e;
            }
        }
    }
}
