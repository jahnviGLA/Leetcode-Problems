// Last updated: 1/19/2026, 1:17:53 PM
class Solution {
    static String d[]={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length()==0) {
            return result;
        }
        keypad(digits,"",result);
        return result;
        
    }
    public static void keypad(String s, String ans, List<String>result){
        if(s.length()==0){
            result.add(ans);
            return;
        }
        char ch=s.charAt(0);
        String p=d[ch-'0'];
        for(int i=0;i<p.length();i++){
            keypad(s.substring(1),ans+p.charAt(i),result);
        }
    }
}