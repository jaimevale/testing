package org.example;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaximaCount {
    public static void main(String[] args) {
        String x = "bccaaacb";
        System.out.println(findMaximumMaximaCount(x));
    }
    
    /////. jev.... WOW gordinfloncin hiciste un codigo muy cortico. Congrats.. super
   public static int findMaximumMaximaCount(String categories) {
        HashMap<Character, Integer> frequencies = new HashMap<>();
        HashMap<Character, Integer> maximaCount = new HashMap<>();
        for(int i = 0; i < categories.length(); i++) {
            char category = categories.charAt(i); // Update frequencies
            int currentFreq = frequencies.containsKey(category) ? frequencies.get(category) +1 : 1;
            frequencies.put(category, currentFreq);
   /////.jev.  yo hubiese escrito frequencies.merge(category,1,Math::sum)  para reemplazar las lineas 20 y 21        
            // Find (several) max in frequencies, increment maximacount of Corresponding key character,
            int max = Collections.max(frequencies.values());
            List<Character> maxFreqs = frequencies.entrySet().stream()
                    .filter(entry -> entry.getValue() == max)
                    .map(Map.Entry::getKey).toList();
 //////.jev. ....WOW WOW WOW fantastico! no lo hubiese logrado hacer tan bonito ... ya me da verguenza mi codigo
            for(Character character : maxFreqs) {
                int currentMaximaCount = maximaCount.containsKey(character) ? maximaCount.get(character) +1 : 1;
                maximaCount.put(character, currentMaximaCount);
//// lo mismo de la linea 22
            }
        }
        return Collections.max(maximaCount.values());
    }
}
