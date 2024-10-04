import java.util.HashMap;

class Solution {
    public int minSubarray(int[] nums, int p) {
        long sum = 0;
    
        for (int num : nums) {
            sum += num;
        }
        long rem = sum % p;
        if (rem == 0) {
            return 0;
        }

       
        HashMap<Long, Integer> h1 = new HashMap<>();
        h1.put(0L, -1);

        long cursum = 0;
        int minLen = nums.length;
        
        for (int j = 0; j < nums.length; j++) {
            cursum = (cursum + nums[j]) % p;

            
            if (cursum < 0) {
                cursum += p;
            }

            
            long needed = (cursum - rem + p) % p;

            if (h1.containsKey(needed)) {
                minLen = Math.min(minLen, j - h1.get(needed));
            }

            h1.put(cursum, j);
        }
        return minLen == nums.length ? -1 : minLen;
    }
}
