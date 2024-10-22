class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int maxOR = 0;
        for (int num : nums) {
            maxOR |= num;
        }
        
       return MaxValueSubset(nums,nums.length,0,0,maxOR);
    }
    public int MaxValueSubset(int[]A,int N,int i,int currentOR,int MaxOR){
        if (i == N) {
        	 return currentOR == MaxOR ? 1 : 0;
    	}
    	
    	
    	int take = 0, notTake = 0;
    	take = MaxValueSubset(A, N, i + 1,currentOR|A[i],MaxOR);
    	notTake = MaxValueSubset(A, N, i + 1,currentOR,MaxOR);
    	
    	
    	return (take + notTake);
    }
}
