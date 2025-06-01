class Solution {
    public long distributeCandies(int n, int limit) {
        long ans=0;
        for(int i=0;i<=Math.min(n,limit);i++){
            ans+=Math.max(Math.min(limit, n - i) - Math.max(0, n - i - limit) + 1, 0);
        }
        return ans;
    }
}
