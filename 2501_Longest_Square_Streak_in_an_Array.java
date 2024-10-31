class Solution {
    public int longestSquareStreak(int[] a) {
        int n = a.length;

        int[] dp = new int[100001];

        int max = 0;
        for(int x : a){
            max = Math.max(max, x);
            dp[x] = 1;
        }


        int ans = -1;
        for(int i = (int)Math.sqrt(max); i >= 2; i--){
            if(dp[i] == 0) continue;
            if(dp[i * i] == 0) continue;

            dp[i] = 1 + dp[i * i];
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
