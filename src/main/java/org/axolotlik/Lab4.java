package org.axolotlik;

import java.util.Scanner;

/**
 * Головний клас для виконання логіки лабораторної роботи.
 */
public class Lab4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. Отримання тексту від користувача
        System.out.println("Введіть текст:");
        // Зчитуємо весь рядок разом із пробілами
        String input = sc.nextLine();

        // Перевірка на порожній ввід (просто про всяк випадок)
        if (input.trim().isEmpty()) {
            System.out.println("Ви не ввели текст. Спробуйте ще раз.");
            sc.close();
            return;
        }

        // 2. Створення об'єктної структури (Текст -> Речення -> Слово -> Літера)
        Text text = new Text(input);

        // 3. Виконання завдання варіанту
        System.out.println("\n--- Виконуємо обробку (видалення попередніх входжень останньої літери)... ---");
        text.performVariantTask();

        // 4. Вивід результату
        System.out.println("\n--- Результат ---");
        System.out.println(text);

        sc.close();
    }
}