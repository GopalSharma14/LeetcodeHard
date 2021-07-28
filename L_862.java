class Solution {
     public int shortestSubarray(int[] A, int K) {
        if(A == null || A.length == 0)
            return 0;
        
        int len = A.length;
        
        int[] dp = new int[len+1]; 
         dp[0]=0;
        for(int i = 1; i<=len; i++){
            dp[i] = dp[i-1]+A[i-1];
        }
         System.out.println(Arrays.toString(dp));
        
        Deque<Integer> dq = new ArrayDeque<>();
        int ans = Integer.MAX_VALUE;
        
        for(int i = 0; i<=len; i++){
            while(!dq.isEmpty() && dp[i] - dp[dq.getFirst()]>=K)
                ans = Math.min(ans, i-dq.pollFirst());
            while(!dq.isEmpty() && dp[i] - dp[dq.getLast()] <=0)
                dq.pollLast();
            dq.addLast(i);
        }           
        return ans ==Integer.MAX_VALUE? -1: ans;
    }
}