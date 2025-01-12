package com.aston.javabase;

public class Homework {

    // Перевернуть строку и вывести на консоль
    //  String string = "I love Java";
    // просто выведу по одному символу в обратном порядке
    public static void turnString(String string) {

        String result = "";
        for (int i = string.length() - 1; i >=0; i--) {
            result = result + string.charAt(i);
        }
        System.out.println(result);
    }

    // int[] ints = {1, 2, 2, 3, 4, 5, 5, 6, 7, 8, 8, 9};
    // Удалить дубликаты из массива и вывести в консоль
    // помнгяю дубликаты на условный -1, выведу все кроме поменяные
    public static void getDistinctNumbers(int[] ints) {
        for (int i = 0; i < ints.length; i++) {
            for (int j = i + 1; j < ints.length; j++) {
                if (ints[i] == ints[j]) {
                    ints[j] = -1;
                }
            }
        }
        for (int i = 0; i < ints.length - 1; i++) {
            if (ints[i] != -1) {
                System.out.print(ints[i] + ", ");
            }
        }
        System.out.print(ints[ints.length - 1]);
        System.out.println();
    }

    // Дан массив, заполненный уникальными значениями типа int.
    // int[] arr = {10, 15, 23, 11, 44, 13, 66, 1, 6, 47};
    // Необходимо найти элемент, который меньше максимума, но больше всех остальных.
    // отсортирую и выведу предпоследную
    public static Integer findSecondMaxElement(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr[arr.length - 2];
    }

    // Найти длину последнего слова в строке. В строке только буквы и пробелы.
    // "Hello world" - 5
    // "    fly me    to the moon    " - 4
    // с конца буду считать колличество символов игнорируя пробелы
    public static Integer lengthOfLastWord(String string) {

        int qt = 0;
        for (int i = string.length() - 1; i >= 0; i--) {
            if (string.charAt(i) != ' ') {
                while (string.charAt(i) != ' ') {
                    qt++;
                    i--;
                }
                return qt;
            }
        }
        return null;

    }

    // Определить, что строка является палиндромом
    // Сложность по памяти O(1), не создавать новые String, StringBuilder
    // Примеры:
    // abc - false
    // 112233 - false
    // aba - true
    // 112211 - true
    // сравниваю начало и коней и по одному символу прближаться, пока не найду отличие или не дойду до середины
    public static boolean isPalindrome(String string) {

        int left = 0;
        int right = string.length() - 1;

        while (left < right) {
            if (string.charAt(left) != string.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;

    }
}
