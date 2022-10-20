package org.example;

import java.util.HashMap;
import java.util.Map;

public class JMaxima {
  public static void main(String[] args){
    String x = "bccaaacb";
    System.out.println(maximaCount(x));
  }

  private static int maximaCount(String x) {
    Map<Character, int[]> freq = new HashMap<>();
    char[] letters = x.toCharArray();
    for (int i=1; i<=letters.length; i++) {
      char c =letters[i-1];
      freq.putIfAbsent(c,new int[letters.length+1]);
      var arr= freq.get(c);
      for(int j=i;j<=letters.length;j++)
        arr[j]=arr[0]+1;
      arr[0]++;
    }
    for (char cat: freq.keySet()) {
      freq.get(cat)[0]=0;
    }
    for (int i=1; i<=letters.length; i++) {
      int max=0;
      for (char cat: freq.keySet()) {
        max=Math.max(freq.get(cat)[i],max);
      }
      for (char cat: freq.keySet()) {
        if(freq.get(cat)[i]==max){
          freq.get(cat)[0]++;
        }
      }
    }
    int maximaMap=0;
    for (char cat: freq.keySet()) {
      maximaMap = Math.max(freq.get(cat)[0],maximaMap);
    }

    return maximaMap;
  }
}
