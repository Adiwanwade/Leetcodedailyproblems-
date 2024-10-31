class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        
        
        int[] LIS = new int[n];
        int[] LDS = new int[n];
        
        
        for (int i = 0; i < n; i++) {
            LIS[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    LIS[i] = Math.max(LIS[i], LIS[j] + 1);
                }
            }
        }
        
        
        for (int i = n - 1; i >= 0; i--) {
            LDS[i] = 1;
            for (int j = n - 1; j > i; j--) {
                if (nums[i] > nums[j]) {
                    LDS[i] = Math.max(LDS[i], LDS[j] + 1);
                }
            }
        }
        
       
        int maxMountainLen = 0;
        for (int i = 1; i < n - 1; i++) {
            if (LIS[i] > 1 && LDS[i] > 1) {
               
                maxMountainLen = Math.max(maxMountainLen, LIS[i] + LDS[i] - 1);
            }
        }
        
        
        return n - maxMountainLen;
    }
}
