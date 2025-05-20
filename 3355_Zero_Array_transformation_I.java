class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] arr = new int[n+1];
        for(int[] query :queries)
        {
            int l = query[0];
            int r = query[1];
            arr[l] +=  1;
            arr[r+1] -= 1;
        }
        // for(int i=1;i<=n;i++)
        // {
        //     arr[i]+=arr[i-1];
        // }
        int sum=0;
        for(int i=0;i<n;i++)
        {   sum+=arr[i];
            if(sum-nums[i]<0) return false;
        }
        return true;


    }
}