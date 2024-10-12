// class Solution {
//     public int maxWidthRamp(int[] nums) {
        
//         int max=0;
//         for(int i=0;i<nums.length;i++){
//               int maxpos=0;
//         for(int j=i+1;j<nums.length;j++){
//             if( nums[i]<=nums[j]){
//                 maxpos=j;
//             }
//         }
//         if(maxpos-i>max){
// max=maxpos-i;
//         }
//         }
//         return max;
//     }
// } //getting TLE so did this approach
class Solution {
    public int maxWidthRamp(int[] nums) {
        int n = nums.length;
        int[] rightMax = new int[n];
        rightMax[n - 1] = nums[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], nums[i]);
        }

        int l = 0, r = 0, rslt = 0;

        while (r < n) {
            while (l < r && nums[l] > rightMax[r]) {
                l++;
            }
            rslt = Math.max(rslt, r - l);
            r++;
        }

        return rslt;
    }
}
