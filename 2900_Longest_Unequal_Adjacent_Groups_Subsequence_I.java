class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> ans = new ArrayList<>();
        int n = words.length;
        int prev = -1;
        for (int i = 0; i < n; i++) {
            if ( groups[i] != prev) {
                prev=groups[i];
                ans.add(words[i]);
            }
        }
        return ans;
    }
}
