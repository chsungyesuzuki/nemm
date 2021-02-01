//Copyright 2021 chsungyesuzuki
//This file is part of Foobar.
//
//        Foobar is free software: you can redistribute it and/or modify
  //      it under the terms of the GNU General Public License as published by
    //    the Free Software Foundation, either version 3 of the License, or
      //  (at your option) any later version.
//
  //      Foobar is distributed in the hope that it will be useful,
    //    but WITHOUT ANY WARRANTY; without even the implied warranty of
      //  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
        //GNU General Public License for more details.
//
  //      You should have received a copy of the GNU General Public License
    //    along with Foobar.  If not, see <https://www.gnu.org/licenses/>.
package nemm;

import nemm.feature.FeatureExecutor;
import nemm.http.HttpClient;

import java.time.Duration;
import java.util.Scanner;

/**
 * Nothing to say.
 * @version 0.0.0
 * @since 0.0.0
 * @author chsungyesuzuki
 */
public class Main{
    /**
     * The http client the program uses.
     * @since 0.0.0
     */
    public static HttpClient client;

    /**
     * nothing to say.
     * @param args nothing to say.
     * @since 0.0.0
     */
    public static void main(String[]args){
        printLicense();
        client=HttpClient.INSTANCE;
        Scanner scanner=new Scanner(System.in);
        while(true) {
            String cmd = scanner.nextLine();
            String[] splitCmd = cmd.split(" ");
            FeatureExecutor.execute(splitCmd);
        }
    }
    private static void printLicense() {
        System.out.println("Copyright 2021 chsungyesuzuki");
        System.out.println("Welcome to nemm.");
        System.out.println("nemm is under GPL 3.0 or later. To check see gpl-3.0.txt or https://www.gnu.org/licenses/gpl-3.0.en.html.");
        System.out.println("https://github.com/chsungyesuzuki/nemm");
    }
}
