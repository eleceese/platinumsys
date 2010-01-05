/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package varios;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MartinJara
 */
public class Main {;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] l = {1,2,3};

        String s = "{";

        for (int i = 0; i < l.length; i++) {
            s =  s + l[i] + ", ";
        }

        s = s.substring(0, s.length()-2) + "}";
        System.out.println(s);
    }

}
