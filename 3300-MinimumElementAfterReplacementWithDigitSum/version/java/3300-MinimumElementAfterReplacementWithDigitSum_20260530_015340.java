// Last updated: 5/30/2026, 1:53:40 AM
1class Solution {
2    public int minElement(int[] nums) {
3        int[] temp= new int[nums.length];
4        for(int i=0;i<nums.length;i++){
5            int r=0, sum=0;
6            while(nums[i]>0){
7                r=nums[i]%10;
8                sum=sum+r;
9                nums[i]=nums[i]/10;
10            }
11            temp[i]= sum;
12        }
13        int min=temp[0];
14        for(int j=1;j<temp.length;j++){
15            if(temp[j]<min){
16                min=temp[j];
17            }
18        }
19
20        return min;
21    }
22}