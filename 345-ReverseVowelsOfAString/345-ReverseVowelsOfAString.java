// Last updated: 1/19/2026, 1:15:46 PM
class Solution {
    public static boolean isvowel(char x) 
    { 
        if (x == 'a' || x == 'e' || x == 'i' || 
            x == 'o' || x == 'u' || x == 'A' || 
            x == 'E' || x == 'I' || x == 'O' || x == 'U'){
           return true;
            }
        else{
            return false;
        }
    }
    public String reverseVowels(String s) {
        char[] chars=s.toCharArray();
        int i=0;
        int j=chars.length-1;
        
        while (i<j) {
            if(isvowel(chars[i])==false) {
                i++;
            }
           else if(isvowel(chars[j])==false) {
                j--;
            }
            else{
            char temp=chars[i];
            chars[i]=chars[j];
            chars[j]=temp;
            i++;
            j--;
            }
        }
        
        String st=new String(chars);
        return st;

    }
}