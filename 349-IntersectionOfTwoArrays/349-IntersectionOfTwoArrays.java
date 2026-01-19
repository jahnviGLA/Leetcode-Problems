// Last updated: 1/19/2026, 1:15:44 PM
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer>l= new ArrayList<>();
        for(int i=0;i<nums1.length;i++){
            l.add(nums1[i]);
        }
        Set<Integer>s= new HashSet<>();
        for(int i=0;i<nums2.length;i++){
            if(l.contains(nums2[i])){
                s.add(nums2[i]);
            }
        }
        int[] ans= new int[s.size()];
        int i=0;
        for(int x:s){
            ans[i]=x;
            i++;
        }
        return ans;
    }
}