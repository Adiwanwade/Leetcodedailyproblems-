class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] arr1 = new int[n];
        Arrays.fill(arr1, 1);
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                arr1[i] = arr1[i - 1] + 1;
            }
        }
        for (int i = n-2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                if (arr1[i] <= arr1[i + 1]) {
                    arr1[i] = arr1[i + 1] + 1;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += arr1[i];
        }
        return ans;
    }
}
