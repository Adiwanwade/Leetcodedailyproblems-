class Solution {
    public char findKthBit(int n, int k) {
        String[] s = new String[20];
        s[0] = "0";
        
        for (int i = 1; i < n; i++) {
            StringBuilder sequence = new StringBuilder();
           
            for (int j = 0; j < s[i - 1].length(); j++) {
                if (s[i - 1].charAt(j) == '1') {
                    sequence.append('0');
                } else {
                    sequence.append('1');
                }
            }
           
            s[i] = s[i - 1] + "1" + sequence.reverse().toString();
        }
        
        return s[n - 1].charAt(k - 1);
    }
}
