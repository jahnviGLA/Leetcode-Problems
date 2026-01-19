// Last updated: 1/19/2026, 1:15:26 PM
class Solution {
    public int[] dailyTemperatures(int[] t) {
        int ans[]= new int[t.length];
        Stack<Integer>st= new Stack<>();
        for(int i=t.length-1;i>=0;i--){
            while(!st.isEmpty()&&t[st.peek()]<=t[i]){
                st.pop();
            }
            if(st.isEmpty()){
                ans[i]=0;
            }
            else{
                ans[i]=st.peek()-i;
            }
            st.push(i);
        }
        return ans;
    }
}