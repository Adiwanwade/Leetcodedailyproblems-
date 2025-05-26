class Solution {
    public int longestPalindrome(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        int length = 0;
        boolean middleUsed = false;

        for (String word : words) {
            String rev = new StringBuilder(word).reverse().toString();

            if (map.getOrDefault(rev, 0) > 0) {
                map.put(rev, map.get(rev) - 1);
                length += 4;
            } else {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }

        for (String key : map.keySet()) {
            if (key.charAt(0) == key.charAt(1) && map.get(key) > 0) {
                length += 2;
                break;
            }
        }

        return length;
    }
}
