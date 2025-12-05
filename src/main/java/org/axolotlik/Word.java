package org.axolotlik;

import java.util.ArrayList;
import java.util.List;

/**
 * Клас, що представляє слово.
 */
public class Word {
    private final List<Letter> letters;

    public Word(String wordString) {
        letters = new ArrayList<>();
        for (char c : wordString.toCharArray()) {
            letters.add(new Letter(c));
        }
    }

    /**
     * Видаляє всі попередні входження останньої літери слова.
     * Наприклад: "banana" (остання 'a') -> стає "bnna".
     */
    public void removePreviousOccurrencesOfLastLetter() {
        // Якщо слово занадто коротке, нічого робити не треба
        if (letters.size() < 2) {
            return;
        }

        // Отримуємо останню літеру (значення char)
        char lastChar = letters.get(letters.size() - 1).getValue();

        // Проходимось у зворотному порядку від передостанньої літери до початку
        for (int i = letters.size() - 2; i >= 0; i--) {

            char currentChar = letters.get(i).getValue();

            if (Character.toLowerCase(currentChar) == Character.toLowerCase(lastChar)) {
                letters.remove(i);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Letter l : letters) {
            sb.append(l.getValue());
        }
        return sb.toString();
    }
}