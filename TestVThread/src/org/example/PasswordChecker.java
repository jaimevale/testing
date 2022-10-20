package org.example;

import java.util.Arrays;
public class PasswordChecker {
    public static void main(String[] args) {
        String[] newPass = {"baacba"};
        String[] oldPass = {"abb"};
        System.out.println(Arrays.toString(checkPasswords(newPass, oldPass)));
    }
    private static String[] checkPasswords (String[] newPasswords, String [] oldPasswords) {
        String[] similar = new String[newPasswords.length];
        Arrays.fill(similar, "NO");
        for (int i = 0; i < newPasswords.length; i++) {
            int similarIndices = 0;
            int oldCounter = 0;
            for (int j = 0; j < newPasswords[i].length(); j++) {
                if (oldCounter == oldPasswords[i].length()) {
                    break;
                }
                char current = newPasswords[i].charAt(j);
                char nextCyclic = nextCharacterInAlphabet(current);
                if (nextCyclic == oldPasswords[i].charAt(oldCounter) || current == oldPasswords[i].charAt(oldCounter)) {
                    similarIndices++;
                    oldCounter++;
                }
            }
            if (similarIndices == oldPasswords[i].length()) {
                similar[i] = "YES";
            }
        }
        return similar;
    }
    private static char nextCharacterInAlphabet ( char character){
        boolean isLower = Character.isLowerCase(character);
        char c = Character.toLowerCase(character);
        if (c < 'a' || c > 'z')
            return character;
        char nextC = (char) ((c - 'a' + 1) % 26 + 'a');
        return isLower ? nextC : Character.toUpperCase(nextC);
    }
}
