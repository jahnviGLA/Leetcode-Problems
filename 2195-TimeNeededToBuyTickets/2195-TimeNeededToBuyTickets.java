// Last updated: 1/19/2026, 1:14:55 PM
class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        Queue<Integer>q= new LinkedList<>();
        for(int i=0;i<tickets.length;i++){
            q.offer(i);
        }
        int timer=0;
        while(!q.isEmpty()){
            int x=q.poll();
            tickets[x]--;
            timer++;
            if(tickets[x]!=0)q.offer(x);
            if(x==k&&tickets[x]==0)break;
        }
        return timer;
    }
}