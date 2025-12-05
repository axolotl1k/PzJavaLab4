package org.axolotlik;

/**
 * Клас, що представляє окрему літеру (символ).
 */
public class Letter {
    private final char value;

    public Letter(char value) {
        this.value = value;
    }

    public char getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}