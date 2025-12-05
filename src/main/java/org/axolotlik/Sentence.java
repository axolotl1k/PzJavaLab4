package org.axolotlik;

import java.util.ArrayList;
import java.util.List;

/**
 * Клас, що представляє речення.
 */
public class Sentence {
    private final List<Object> sentenceMembers;

    public Sentence(String sentenceString) {
        sentenceMembers = new ArrayList<>();
        // Розбиваємо по пробілах, зберігаючи розділові знаки
        String[] parts = sentenceString.split("(?=[,.!?:;])|\\s+");

        for (String part : parts) {
            if (part.isEmpty()) continue;

            if (part.matches("[,.!?:;]")) {
                sentenceMembers.add(new Punctuation(part.charAt(0)));
            } else {
                sentenceMembers.add(new Word(part));
            }
        }
    }

    /**
     * Викликає обробку (видалення літер) для кожного слова в реченні.
     */
    public void processWords() {
        for (Object member : sentenceMembers) {
            if (member instanceof Word) {
                ((Word) member).removePreviousOccurrencesOfLastLetter();
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sentenceMembers.size(); i++) {
            Object member = sentenceMembers.get(i);
            sb.append(member.toString());

            if (i < sentenceMembers.size() - 1) {
                Object next = sentenceMembers.get(i + 1);
                if (!(next instanceof Punctuation)) {
                    sb.append(" ");
                }
            }
        }
        return sb.toString();
    }
}