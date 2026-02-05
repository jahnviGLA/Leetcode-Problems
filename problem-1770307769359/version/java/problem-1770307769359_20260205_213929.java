// Last updated: 2/5/2026, 9:39:29 PM
1class Solution {
2    public List<String> fizzBuzz(int n) {
3        List<String> arr = new ArrayList<>();
4        for(int i=1;i<=n;i++){
5            if(i%3==0 && i%5==0){
6                arr.add("FizzBuzz");
7            }
8            else if(i%3==0){
9                arr.add("Fizz");
10            }
11            else if(i%5==0){
12                arr.add("Buzz");
13            }
14            else{
15                arr.add(String.valueOf(i));
16            }
17        }
18        return arr;
19    }
20}