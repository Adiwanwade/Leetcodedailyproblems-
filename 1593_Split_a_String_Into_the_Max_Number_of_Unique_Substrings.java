class Solution {
    public int maxUniqueSplit(String s) {
        return backtrack(s, 0, new HashSet<>());
    }

    private int backtrack(String s, int start, Set<String> set) {
        if (start == s.length()) {
            return 0;
        }

        int maxCount = 0;
        String currentSubstr = "";

        for (int i = start; i < s.length(); i++) {
            currentSubstr += s.charAt(i);
            if (!set.contains(currentSubstr)) {
                set.add(currentSubstr);
                int count = 1 + backtrack(s, i + 1, set);
                maxCount = Math.max(maxCount, count);
                set.remove(currentSubstr);
            }
        }

        return maxCount;
    }
}
