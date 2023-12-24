package PS.leetCode.TwoPointers;

public class Valid_Palindrome {
  public boolean isPalindrome(String s) {
    String str = s.replaceAll("[^\uAC00-\uD7A30-9a-zA-Z]","").replaceAll(" ","");
    str = str.toLowerCase().trim();
    System.out.println(str);
    for(int i = 0; i<str.length()/2; i++){
      if(!isPalindrom(str,i)){
        return false;
      }
    }
    return true;
  }
  public static boolean isPalindrom(String str, int i){
    if(str.charAt(i) != str.charAt(str.length()-i-1)){
      return false;
    }
    return true;
  }
}
