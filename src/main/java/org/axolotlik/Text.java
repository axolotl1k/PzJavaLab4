package org.axolotlik;

import java.util.ArrayList;
import java.util.List;

/**
 * Клас, що представляє текст.
 */
public class Text {
    private final List<Sentence> sentences;

    public Text(String textString) {
        sentences = new ArrayList<>();
        String[] sentenceStrings = textString.split("(?<=[.!?])\\s+");

        for (String s : sentenceStrings) {
            sentences.add(new Sentence(s));
        }
    }

    /**
     * Виконує завдання варіанту для всього тексту.
     */
    public void performVariantTask() {
        for (Sentence sentence : sentences) {
            sentence.processWords();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Sentence sentence : sentences) {
            sb.append(sentence).append(" ");
        }
        return sb.toString().trim();
    }
}