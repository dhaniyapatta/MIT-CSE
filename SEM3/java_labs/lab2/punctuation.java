/* Write and execute a java program to current string containing number into comma-punctuation number,with a comma every 3rd digits
from the right*/
package lab5;

import java.util.Scanner;

public class punctuation {
    static String addStr(String str) {
        int j = 0;
        String newString = "";
        for (int i = str.length() - 1; i >= 0; --i) {
            char ch = str.charAt(i);
            if ((++j) % 3 == 0 && i > 0) {
                newString = "," + ch + newString;
            } else {
                newString = ch + newString;
            }
        }
        return newString;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner((System.in));
        System.out.println("Enter a number : ");
        String string = scanner.nextLine();
        System.out.println("ORIGINAL STRING IS = " + string + ",\tMODIFIED STRING IS = " + addStr(string));
    }
}