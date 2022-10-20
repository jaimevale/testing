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
 ///// si tu codigo es mucho más simple que el mio. realmente no te complicaste con la generación de las combinaciones de letras.
 ////// tienes toda la razon. No se necesitaba construir las combinaciones sino probar con las dos posibilidaes de cada letra.
 ////// feli: muy bien. Felicitaciones.
        }
        return similar;
    }
    private static char nextCharacterInAlphabet ( char character){
        boolean isLower = Character.isLowerCase(character);
        char c = Character.toLowerCase(character);
        if (c < 'a' || c > 'z')
            return character;
        char nextC = (char) ((c - 'a' + 1) % 26 + 'a');
   ////jev: muy lindo. Yo intente escribir esto mismo y finalmente fui menos prolijo y simplemente considere solo el caso del z. Excelente.
        return isLower ? nextC : Character.toUpperCase(nextC);
    }
}
