package com.twilight.task3;

import java.security.SecureRandom;
import java.util.Scanner;

public class GeneratePass {
public static final String LOWCASE ="abcdefghijklmnopqrstuvwxyz";
public static final String UPCASE = LOWCASE.toUpperCase();
public static final String NUMBERS ="0123456789";
public static final String SPECIAL_CHARS ="!@#$%^&*()-_=+[]{};:'\\\"<>?/";

public static SecureRandom rand = new SecureRandom();
    public static int[] generateLength(int length) { // генерируем случайную длинну каждой строки >=0

        int[] result = new int[4];

        result[0] = rand.nextInt(length - 3) + 1;
        result[1] = rand.nextInt(length - result[0] - 2) + 1;
        result[2] = rand.nextInt(length - result[0] - result[1] - 1) + 1;

        result[3] = length - result[0] - result[1] - result[2];

        if (result[3]<=0) { // если одно из чисел = 0 то занаво запускаем функцию
            return generateLength(length);
        }
        return result;
    }

    private static void addRandomChars(StringBuilder pass, String charSet, int length) { // добавляем символы в пароль
        for (int i = 0; i < length; i++) {
            pass.append(charSet.charAt(rand.nextInt(charSet.length())));
        }
    }

    public static String generatePass(int length) { // создаём пароль
        int[] lengths = generateLength(length);
        StringBuilder pass = new StringBuilder(length);
        addRandomChars(pass, LOWCASE, lengths[0]);
        addRandomChars(pass, UPCASE, lengths[1]);
        addRandomChars(pass, NUMBERS, lengths[2]);
        addRandomChars(pass, SPECIAL_CHARS, lengths[3]);

        return shufflePass(pass.toString());
    }

    public static String shufflePass(String input) { // перемешиваем пароль
        char[] chars = input.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int randIndex = rand.nextInt(chars.length);
            char temp = chars[i];
            chars[i] = chars[randIndex];
            chars[randIndex] = temp;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите длинну пароля от 8 до 12: ");
        int passLength = sc.nextInt();

        if (passLength <= 12 && passLength >= 8) {
            String pass = generatePass(passLength);
            System.out.println(pass);
        } else {
            System.out.println("Неверная длина пароля");
        }

    }
}
