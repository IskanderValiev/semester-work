package ru.isko.parsers;

import java.util.Arrays;
import java.util.Scanner;

/**
 * created by Iskander Valiev
 * on 11/25/17
 *
 * @author Iskander Valiev (Kazan Federal University Higher School of Information Technologies and Information Systems)
 * @version 1.0
 */

public class PhoneNumberParser {

    public String phoneParse(String phoneNumber) {
        char[] chars = new char[phoneNumber.length()];
        chars = phoneNumber.toCharArray();
        chars[0] = '7';
        return Arrays.toString(chars);
    }

//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        PhoneNumberParser p = new PhoneNumberParser();
//        System.out.println(p.phoneParse(scanner.nextLine()));
//    }
}
