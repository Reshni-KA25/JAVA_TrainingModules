package com.demo1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StringFunctions {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int ch;

        do {
          
            System.out.println("\n--- Enter your choice ---");
            System.out.println("1. Word count \n2. Reverse String \n3. Character Frequency");
            System.out.println("4. Exit");
            
            ch = sc.nextInt();
            sc.nextLine(); 

            switch (ch) {

                case 1:
                    System.out.print("Enter a sentence: ");
                    String s1 = sc.nextLine();
                    System.out.println("Word Length = " + wordCount(s1));
                    break;

                case 2:
                    System.out.print("Enter a sentence: ");
                    String s2 = sc.nextLine();
                    System.out.println("Reverse is = " + reverse(s2));
                    break;

                case 3:
                    System.out.print("Enter a sentence: ");
                    String s3 = sc.nextLine();
                    System.out.println(charFreq(s3));
                    break;

                case 4:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }

        } while (ch != 4);
    }
     
   public static int findLength(String in) {
      String s = in.replaceAll("\\s+", "");
        return s.length();
    }

    public static int wordCount(String in) {
     if (in == null || in.trim().isEmpty()) {
        return 0; 
     }

     String[] words = in.trim().split("\\s+");
     return words.length;
    }


    public static String reverse(String input) {
        StringBuilder sb = new StringBuilder(input);
        return sb.reverse().toString();
    }

  public static Map<Character, Integer> charFreq(String input) {

    Map<Character, Integer> map = new HashMap<>();

    for (int i = 0; i < input.length(); i++) {
        char c = input.charAt(i);
        map.put(c, map.getOrDefault(c, 0) + 1);
    }
   return map;
}

}
