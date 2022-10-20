package org.example;

import java.util.Arrays;

public class JPasswordChecker {

  public static void main(String[] args) {
    System.out.println(" prueba ok de isSubsequence: "+isSubsequence("abcdes","bce"));
    System.out.println(" prueba ko de isSubsequence: "+isSubsequence("abcder","bcm"));
    System.out.println(" prueba change letters abcde>accef 01011: "+changeLetter(0b01011,"abcde"));


    String[] newPass = {"baacba"};
    String[] oldPass = {"abb"};
    Arrays.stream(checkPasswords(newPass, oldPass)).forEach(System.out::println);

  }

  private static String[] checkPasswords(String[] newArray, String[] oldArray) {
    var result = new String[newArray.length];
    for (int i=0;i< result.length;i++) {
      result[i]= checkPassword(newArray[i],oldArray[i])?"YES":"NO";
    }
    return result;
  }

  private static boolean checkPassword(String newPass, String oldPass) {
    if(isSubsequence(newPass,oldPass))
      return true;
    else{
      // 2 ^ n cambios
      for (int i = 0; i < Math.pow(2,newPass.length()); i++) {
        String testPass = changeLetter(i,newPass);
        if(isSubsequence(testPass,oldPass))
          return true;
      }
    }
    return false;
  }

  private static boolean isSubsequence(String newPass, String oldPass) {
    int contOld=0;
    for (int i = 0; i <newPass.length() ; i++) {
      if(newPass.charAt(i)==oldPass.charAt(contOld)){
        contOld++;
        if(contOld == oldPass.length()) return true;
      }
    }
    return contOld == oldPass.length();
  }

  private static String changeLetter(int i, String newPass) {
    int acm=i;
    char[] result = newPass.toCharArray();
    for (int j = newPass.length()-1; j >= 0 ; j--) {
      var changeLetter = acm % 2;
      acm >>= 1;
      if(changeLetter==1){
        result[j]=(char)(result[j]+1);
        if(result[j]==123) result[j]='a';
      }
    }
    return String.valueOf(result);
  }


}


